https://www.youtube.com/@ezcd

```text
17. DB MVCC 개념 설명합니다 ! MVCC가 각각의 isolation level에서 어떻게 동작하는지도 MySQL & postgreSQL 예제와 함께 설명합니다
    MVCC(multiversion concurrency control)
    isolation level과 함께 MVCC case study (MySQL, postgreSQL)
    
    00:13 MVCC 등장 배경
        기존의 Lock-based 의 concurrency control 에서는 read - read 에서만 허용을 하여,
        write 가 한쪽이라도 들어가면 한쪽이 실행되면 다른 한쪽은 block 이 되어 기다리게 되기 때문에 성능 문제가 있다.
        MVCC 는 write - write 이 외에는 block 이 되지않고 동시에 처리할 수 있다.
    01:11 MVCC 설명 (예제와 함께)
        tx1 x를 읽는다. tx2 x를 50으로 바꾼다. db x=10.
        
        tx2 : write_lock(x)
        tx2 : write(x=50)           (트랜잭션이 자체적으로 x=50 이라는 값을 가지고 있다.)
        tx1 : read(x) => 10         (MVCC 는 Commit 된 데이터만 읽는다.)
        tx2 : commit                (트랜잭션이 자체젹으로 가지고 있던 x=50 이라는 값을 데이터베이스에 반영한다.)
        tx2 : unlock(x)             (recoverability 를 위해 commit 할 때 write_lock 을 unlock 한다, rollback 을 위해서)
        tx : read(x) => ?
            (tx1의 isolation level 에 따라 읽는 값이 다르다.
            read committed - read 하는 시간을 기준으로 그전에 commit 된 데이터를 읽는다. so x == 50
            repeatable read - tx 시작 시간을 기준으로 그전에 commit 된 데이터를 읽는다. so x == 10
            read uncommitted - MVCC 는 committed 된 데이터를 읽기 때문에 이 level 에서는 보통 MVCC 가 적용되지 않는다.
                그래서 MVCC 가 적용되는 level 을 MySQL 에서는 read committed 또는 repeatable read 라 하고,
                postgre 에서는 read uncommitted 가 존재하지만 read committed level 처럼 동작한다.)
            (Serializable 상황에서는 MySQL 에서는 MVCC 로 동작하기 보다는 lock 으로 동작한다.
            PostgreSQL 에서는 SSL(Serializable Snapshot Isolation)기법이 적용된 MVCC 로 동작한다.)
        MVCC 특징
            1. 데이터를 읽을 때, 특정 시점 기준으로 가장 최근에 commit 된 데이터를 읽는다.
                (Commit 된 데이터만 읽는다. MySQL 에서는 Consistence read 라고 부른다, 문서를 읽을 때 이렇게 이해하면 된다.)
            2. 데이터 변화(write) 이력을 관리한다.
                (1번을 충족하기 위해서 데이터 변화 이력, change 가 발생할 때마다 변화이력을 RDBMS 가 내부적으로 관리를 해줘야 한다. 
                그래서 MVCC 는 추가적으로 저장 공간을 많이 쓰게 된다. 요게 단점.)
            3. read 와 write 는 서로를 block 하지 않는다.(단점보다 더 큰 장점.)
    
    10:19 postgreSQL에서 lost update 문제와 해결
        tx1 x가 y에 40을 이체한다. tx2 x에 30을 입금한다. db x=80 y=50
    
        tx1 : read(x) => 50     (트랜잭션이 자체적으로 x=50이라는 값을 갖는다.)
        tx1 : write_lock(x)     
        tx1 : write(x=10)       (트랜잭션이 자체적으로 가지고 있던 x=50 에서 x=10으로 변경한다.)
        tx2 : read(x) => 50
        tx2 : write(x=80)       (x 의 lock 이 없으므로 BLOCK 상태)
        tx1 : read(y) => 10
        tx1 : write_lock(y)
        tx1 : write(y=50)
        tx1 : commit            (트랜잭션이 자체적으로 가지고 있던 x=10 y=50을 데이터베이스에 반영한다.)
        tx1 : lock(x)
        tx1 : lock(y)
        tx2 : write_lock(x)
        tx2 : write(x=80)       (tx1의 락이 반환되어 락을 획득하고 write 한다.)
        tx2 : commit
        tx2 : lock(x)
    
        생각했던 결과는 x=40 y=50 이었지만 x=80 y=50 이라는 결과를 만들었다.
        이것을 LOST UPDATE 라고 한다.
            tx1 : read(x) => 50
            tx1 : write(x=10)
            이와 같이 업데이트한 정보가 사라진것이다.
        해결 방법
            tx1 의 isolation level 은 read commited 였고
            tx2 의 isolation level 은 read commited 였는데 tx2 를 repeatable read 로 바꾸면
            tx2 : write(x=80) 이 시점에서 rollback 된다.
            (postgre 에서는 repeatable read 에서
            같은 데이터에 먼저 update 한 tx 가 commit 되면 나중 tx 는 rollback 된다는 규칙이 있다.
                만약 앞에 tx 가 rollback 하면 상관 없다.
            그래서 tx2 가 재시도를 한다면 원하는 결과를 얻을 수 있다.
            이런 특징을 first-updater-win 이라 한다.)
            
        위와 같이 트랜잭션 마다 isolation level 을 줄 수 있다.
        tx1 은 read commited 여도 괜찮은가 ?
            반대로 tx2 가 먼저 실행한다면 결과는 tx1 의 값이 반영되고 tx2 의 결과는 LOST UPDATE 가 발생한다.
            그래서 tx1 도 repeatable read 로 바꿔 줘야한다.
            그러면 tx1 은 rollback 되고 tx2 만 반영되게 된다.
            결국 하나의 트랜잭션만 바꾼다고 해서 문제가 해결되지 않는다. 연관있는 다른 트랜잭션도 챙겨줘야 한다.
        
20:01 mySQL에서 lost update 문제
    MySQL 에서는 "같은 데이터에 먼저 update 한 tx 가 commit 되면 나중 tx 는 rollback 된다는 규칙이 있다."라는 개념이 없다.
    tx1 tx2 모두 repeatable level 이라 해도 두 트랜잭션 모두 실행된다.
    그래서 여전히 LOST UPDATE 가 발생한다.

18. DB MVCC 이어서 설명합니다 ! MySQL & postgreSQL 예제와 함께 확인해 보세요 ! (feat. select ... for update)
    

    00:00 1부 영상 소개
    00:22 mySQL에서 lost update 해결
    05:33 repeatable read에서 write skew 문제
    07:47 MySQL에서 write skew 해결
    10:11 postgreSQL에서 write skew 해결
    13:32 serializable (두 RDBMS의 차이)
    15:25 MVCC 참고 사항
    15:56 클로징









































```