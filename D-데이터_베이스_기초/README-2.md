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
    00:22 mySQL에서 lost update 해결
        tx1 repeatable read, x가 y에 40을 이체한다. tx2 repeatable read, x에 30을 입금한다. db x=80 y=50
        
        tx2 : read(x) => 50         
            (MySQL 에서는 개발자가 SELECT balance FROM account WHERE id = 'x' FOR UPDATE 와 같이
            FOR UPDATE 를 작성해주므로써 Locking read 가 되어 read(x) 를 하면서도 x 에 대한 write lock 을 취득할 수 있다.)
        tx1 : read(x)
            (여기서도 write 를 위한 read 이기에 Locking read 를 사용해야한다.
            그리고 이미 x 에 대한 락은 tx2 가 먼저 가져갔기에 tx1 은 락을 기다리게 된다.)
        tx2 : write(x=80)
        tx2 : commit        (lock 반환과 동시에 tx1 의 read(x)는 락을 획득한다.)
        tx1 : read(x) => 80
            (repeatable read 의 level 이기에 트랜잭션이 시작하는 순간의 기준으로 데이터를 읽을 것이라 생각되지만
            isolation level 과 상관없이 locking read 로 인해서 가장 최근의 commit 된 데이터를 읽게되어 50이 아닌 tx2 를 통해 반영된 80을 읽는다.)
        tx1 : write(x=40)   (트랜잭션 자체적으로 x=40 의 값을 가진다.)
        tx1 : read(y)       (이때도 마찬가지로 locking read 를 사용한다.)
        tx1 : write(y=50)
        tx1 : commit
        
        이렇게 MySQL 에서는 LOST UPDATE 를 방지하기 위해서 Locking read 를 사용해야한다.
        isolation level 로만은 해결되지 않는다.
        
        Locking read 사용법
        SELECT ... FOR UPDATE; exclusive lock
        SELECT ... FOR SHARE;  shared lock
            write-lock (exclusive lock)
                read/write(insert, modify, delete)할 때 사용된다.
                다른 tx가 같은 데이터를 read/write하는 것을 허용하지 않는다.
            read-lock (shared lock)
                read 할 때 사용한다.
                다른 tx가 같은 데이터를 read하는 것은 허용한다.
        다른 RDBMS 에서도 위와같은 문법을 지원하지만 동작방식이 조금 다르다.
        
        locking read 와 consistence lock 이라는 용어를 사용한다는 점 기억하자.
        
    05:33 repeatable read에서 write skew 문제
        tx1 repeatable read, x=x+1. tx2 repeatable read, y=x+y. db x=10 y=10
        
        tx1 : read(x) => 10
        tx2 : read(x) => 10
        tx1 : read(y) => 10
        tx2 : read(y) => 10
        tx1 : write(x=20)
        tx2 : write(x=20)
        tx1 : commit
        tx2 : commit
        
        기대한 값은 x=20 y=30 이지만 결과는 x=20 y=20 이다.
        이것을 WRITE SKEW 라고 한다.
        이 현상은 MySQL, PostgreSQL 모두 나타날 수 있는 증상이다.
    
    07:47 MySQL에서 write skew 해결
        locking read 로 해결해야한다.
        isolation level 을 한층 더 올려서 해결할 수 있다.(serializable)
    
    10:11 postgreSQL에서 write skew 해결
        locking read 를 사용하면, MySQL 과 다른 동작방식으로 해결된다.
        
        postgre 는 repeatable level 일 때, 같은 데이터에 먼저 update 한 tx 가 commit 되면 이후에 tx 은 rollback 되는 성질로 인해서
        tx1 이 끝나고 locking read 를 얻는 tx2 가 for update 를 해도 read 는 실패를 하고 rollback 이 된다.
    
        rollback 이 되지 않고 해결을 원한다면 isolation level 을 한층 더 올려서 해결할 수 있다.(serializable)
    
    13:32 serializable (두 RDBMS의 차이)
        가장 강력한 isolation level 이기 때문에 어떠한 이상 현상도 발생하지 않는다.
        
        MySQL
            repeatable read 와 유사
            tx 의 모든 평범한 select 문은 암묵적으로 select... for share 처럼 동작한다.
                (MVCC 보다는 lock 으로 동작을 한다고 보통 얘기한다.
                for update 가 아닌 for share 를 사용하는 이유는 성능 때문이다. for update 는 exclusive lock 이기 때문.
                for share 는 for update 에 비해 데드락(dead lock)이 발생할 가능성이 높다.)
            SELECT ... FROM ... => SELECT ... FROM ... FOR SHARE 로 자동으로 바꿔준다.
            
        PostgreSQL
            특징 : SSI(serializable snapshot isolation)로 구현 - 여전히 MVCC 로 동작을 하면서 모든 이상현상을 막아주는 isolation 기법
            동작방식 : first-committer-winner

트랜잭션 마무으리
```