# 💡운영체제 기초
```text
용어
    프로그램
        컴퓨터가 실행할 수 있는 명령어들의 집합
    프로세스
        컴퓨터에서 실행 중인 프로그램
        각각의 프로세스는 독립된 메모리 공간을 할당 받음
        명령어들과 데이터를 가짐
    CPU(central processing unit)
        명령어를 실행하는 연산 장치
    메인 메모리(main memory)
        프로세스가 CPU에서 실행되기 위해 대기하는 곳(프로세스의 명령어들과 실행중인 데이터들이 있기도 하다)
    IO(input/output)
        파일을 읽고 쓰거나
        네트워크의 어딘가와 데이터를 주고 받는 것
        입출력 장치와 데이터를 주거나 받는 것

1. 프로세스 및 스레드의 이해
   단일 프로세스 시스템
       한 번에 하나의 프로그램만 실행됨
       단점
           CPU 사용률이 좋지 않음
           (실행중인 프로세스가 IO 작업을 하게되는 동안 CPU는 아무것도 안하게 되는 현상)
       해결책
           여러 개의 프로그램을 메모리에 올려놓고 동시에 실행시키자!
           IO 작업이 발생하면 다른 프로세스가 CPU에서 실행됨

   멀티프로그래밍(multiprogramming, 단일 프로세스 시스템의 해결책)
       CPU 사용률을 극대화 시키는데 목적
       단점
            CPU 사용 시간이 길어지면 다른 프로세스는 계속 대기
       해결책
            프로세스는 한번 CPU를 사용할 때, 아주 짧은 시간(=quantum)만 CPU에서 실행되도록 하자!

   멀티태스킹(multitasking, 멀티 프로그래밍의 해결책)
       프로세스의 응답 시간을 최소화 시키는데 목적(마치 여러 프로그램이 동시에 실행되는 느낌)
       단점
           하나의 프로세스가 동시에 여러 작업을 수행하지는 못함
           프로세스의 컨텍스트 스위칭은 무거운 작업(컨텍스트 스위칭 : 프로세스 교체작업)
           프로세스끼리 데이터 공유가 까다로움(두개의 프로그램의 메모리 공간이 독립적으로 나뉘어져 공유가 까다로움)
           듀얼 코어가 등장했는데, 잘 쓰고 싶음
       해결책
            쓰레드

   쓰레드 특징
       프로세스는 한 개 이상의 스레드를 가질 수 있다.(한 프로세스위에 여러 작업을 동시에 실행하기 위함)
       CPU 에서 실행되는 단위(unit of execution)
            전에는 프로세스가 CPU 에서 실행되는 단위였다.
       같은 프로세스의 스레드들끼리 컨텍스트 스위칭이 가볍다.
       스레드들은 자신들이 속한 프로세스의 메모리 영역을 공유(Heap 메모리)

   멀티프로세싱(multiprocessing)
       두 개 이상의 프로세서나 코어를 활용하는 시스템
       코어가 두개인 CPU, 병렬로 동시에 두개의 프로세스가 실행

   멀티스레딩(multithreading, 확장된 멀티태스킹 개념)
       하나의 프로세스가 동시에 여러 작업을 실행하는데 목적
       여러 프로세스와 여러 스레드가 아주 짧게 쪼개진 CPU time을 나눠 갖는 것

2. 스레드 컨텍스트 스위칭과 프로세스 컨텍스트 스위칭 차이
   컨텍스트 스위칭(context switching)
       CPU/코어에서 실행 중이던 프로세스/스레드가 다른 프로세스/스레드로 교체되는 것
       하나의 프로세스는 하나의 스레드를 가진다, 다른 프로세스에 속한 스레드들에 바뀌는 것.
   컨텍스트
       프로세스/스레드의 상태, CPU 메모리 등등
       CPU 는 resiters 가 있다(프로그램 카운터, 스택 포인터 등등)
   컨텍스트 스위칭이 왜 필요한가 ?
        여러 프로세스/스레드를 동시에 실행시키기 위해서
   컨텍스트 스위칭은 언제 발생하는가 ?
        주어진 time slice(quantum)를 다 사용했거나 IO 작업을 해야하거나 다른 리소스를 기다리거나 so on..
   컨텍스트 스위칭은 누구에 의해 실행되는가 ?
       OS 커널(kernel)
           각종 리소스를 관리/감독하는 역할
           컨텍스트 스위칭을 집행하는 존재, 수행하는 존재를 말한는거지 트리거나 발생시키는 걸 얘기하는게 아니다.
           컨텍스트 스위칭은 구체적으로 어떤 과정으로 일어나는가 ?
           다른 프로세스끼리 스위칭(process context switching)이냐 같은 프로세스의 스레드들끼리 스위칭(thread context switching)인지에 따라 다르다
       둘의 공통점
           1. 커널 모드에서 실행
           프로세스가 하드웨어 또는 컴퓨터 리소스를 다뤄야 한다면 프로세스가 아닌 운영체제에서 접근하는데 운영체제에서도 커널을 통해 접근한다.
           이때 프로세스에서 커널로 통제권이 넘어가서 커널에 의해 실행되는 것을 커널 모드라고 한다.
           2. CPU의 레지스터(각종 명령어를 수행하기 위해 필요한 데이터를 저장하는 존재) 상태를 교체
           다른 프로세스로 교체하기 위해 기존에 실행되던 프로세스의 레지스터 상태를 저장해야한다.
       둘의 차이점
           같은 프로세스의 스레드들 간의 컨텍스트 스위칭(C.S)
           기존 쓰레드 실행 -> 커널모드 진입 -> 기존 쓰레드 CPU 상태 저장 -> 실행할 쓰레드 CPU 상태 로딩 -> 새로운 쓰레드 실행 -> 반 -> 복 ...
           프로세스 컨텍스트 스위칭은 가상(virtual) 메모리 주소 관련 처리를 추가로 수행
           기존 프로세스 실행 -> 커널모드 진입 -> 기존 프로세스 CPU 상태 저장 -> 실행할 프로세스 CPU 상태 로딩 -> MMU(memory management unit)이 실행할 프로세스의 메모리 공간을 바라보게 하고 캐쉬 TLB(가상의 메모리 주소와 실제 메모리 주소의 매핑 정보)를 비워준다. -> 새로운 프로세스 실행 -> 반 -> 복 ...
       결론
            MMU(memory management unit)이 실행할 프로세스의 메모리 공간을 바라보게 하고 캐쉬 TLB(가상의 메모리 주소와 실제 메모리 주소의 매핑 정보)를 비워주는 차이
   스레드 컨텍스트 스위칭이 더 빠른 이유는 ?
       메모리 주소 관련 처리는 하지 않기 때문
       같은 메모리 공간을 공유하기 때문
   컨텍스트 스위칭이 미치는 간접적인 영향은 ?
       캐시(cache) 오염(pollution)
       CPU 안에는 기본적으로 캐시가 있는데, 자주 쓰는 정보를 캐시에 담아 둔다.
       문제는 각 프로세스는 서로 다른 데이터를 사용하기에 컨텍스트 스위칭을 한 직후에는 캐시에 내가 찾는 데이터가 없어서 다시 메모리에서 데이터를 가져와야하기에 성능에 영향을 미친다.
       기본적으로 CPU 캐시는 사용되는 프로세스에게 전부 할당된다
   유저 관점(어플리케이션)에서 컨텍스트 스위칭이란 ?
       순수한(pure) 오버헤드(overhead)
       내가 실행한 이 프로그램의 동작과는 전혀 상관없는 CPU를 잡아먹는 간접비용이다.

3. CPU bound, io bound 의 의미와 이 두 가지가 프로그램의 스레드 개수를 결정하는데 어떤 영향을 주는지에 대한 이해
   CPU(central processing unit)
        프로세스의 명령어를 해석하고 실행하는 장치
   IO(input/output)
        파일을 읽고 쓰거나 네트워크의 어딘가와 데이터를 주고 받는 것
        입출력 장치와 데이터를 주거나 받는 것
   버스트(Burst)
        어떤 현상이 짧은 시간 안에 집중적으로 일어나는 일
   CPU 버스트
        프로세스가 CPU 에서 한번에 연속적으로 실행되는 시간
   IO 버스트
        프로세스가 IO 작업을 요청하고 결과를 기다리는 시간

   프로세스의 인생은 CPU 버스트와 IO 버스트의 연속

   CPU bound 프로세스
       CPU burst가 많은 프로세스(io burst 는 적음)
       예) 동영상 편집 프로그램, 머신러닝 프로그램(io작업이 적고, 연산작업이 많음)
   IO bound 프로세스
       IO burst 가 많은 프로세스
       예) (일반적인) 백엔드 API 서버(bd, cach 서버 사용)

   듀얼 코어 CPU 에서 동작할 CPU bound 프로그램을 구현한다면 몇 개의 스레드를 쓰는게 좋을까요 ?
       Goetz(2002, 2006) recommends
       - CPU bound 프로그램에서 적절한 스레드 수는 number of CPUs + 1
       CPU 또는 코어의 개수에 하나를 더 한 것의 스레드 개수가 가장 좋다
       CPU 2개 프로세스의 스레드 4개라면 스레드 2개 씩 CPU 하나를 담당하기 때문에, 프로세스 실행하면 스레드 간 컨텍스트 스위칭이 발생
       CPU 2개 프로세스의 스레드 2개라면 스레드 1개 씩 CPU 하나를 담당하기 때문에, 프로세스 실행하면 스레드 간 컨텍스트 스위칭이 발생하지 않는다.
       C.S 는 큰 비용이다.
   IO bound 프로그램은 스레드 몇 개로 구현이 적절할까 ?
       컴퓨터 스팩, 프로그램 특성 등.. 에 맞춰서
       만약 API 서버가 thread per request 방식이라면 ?(요청마다 담당 스레드를 하나씩 두는 방식, 10개를 만들어두고 요청 3개가 들어오면 7개가 놀게된다)
       몇 개의 스레드들을 미리 만들어 놓을지 여러 상황을 고려해서 결정하는 것이 필요

4. 동기화(synchronization)
   하나의 객체를 두 개의 스레드가 접근할 때 생긴일
   for..
   count();		코드 실행

   	LOAD state to R1	운영체제 명령어, 여러 복합문의 명령어
   	R1 = R1 + 1 		연산
   	STORE R1 to state	메모리 상태값 변경

   	스레드 1,2이 실행되며 메모리 state 값을 2로 기대하지만,
   	연산과정에서 컨텍스트 스위칭으로 인해 스레드 스레드 2는 스레드 1의 값이 반영되지 않은 상태에서 연산되기에 메모리 state 값이 1로 나올 수 있다.

   race condition(경쟁 조건)
       여러 프로세스/스레드가 동시에 같은 데이터를 조작할 때,
       타이밍이나 접근 순서에 따라 결과가 달라질 수 있는 상황.
   동기화(synchronization)
       여러 프로세스/스레드를 동시에 실행해도 공유 데이터의 일관성을 유지하는 것
   어떻게 동기화 시킬 것인가 ?
       해당 명령어를 실행할 땐, 컨텍스트 스위칭을 막아버린다.
       싱글 코어에서만 가능, 각 코어마다 다른 스레드 보유
       count() 실행 시, 한 스레드만 실행 가능하게 한다.
       critical section(임계 영역, critical section problem)
       공유 데이터의 일관성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역 
   do {
       entry section
       critical section
       exit section
       remainder section
   } while (TRUE)
   critical section probblem의 해결책이 되기 위한 조건
       1. mutual exclusion (상호 배제)
            한번에 하나의 프로세스/스레드만 critical section에서 실행할 수 있다.
       2. progress (진행)
            만약에 critical section이 비어있고 프로세스/스레드가 들어가길 원한다면, 그 중에 하나는 critical section 안에서 실행될 수 있도록 해야한다.
       3. bounded waiting (한정된 대기)
            어떤 프로세스/스레드가 무한정 기다리고 있으면 안된다.
5. 동기화를 위한 전략과 차이
   race condition(경쟁 조건)
       여러 프로세스/스레드가 동시에 같은 데이터를 조작할 때, 타이밍이나 접근 순서에 따라 결과가 달라질 수 있는 상황
   동기화(synchronization)
       여러 프로세스/스레드를 동시에 실행해도 공유 데이터의 일관성을 유지하는 것
   critical section(임계 영역)
       공유 데이터의 일관성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역
       (하나의 스레드/프로세스 만 진입해서 실행 - mutual exclusion)
   어떻게 mutual exclusion을 보장할 수 있을까 ?
       락(lock) 사용
       do {
           acquire lock				락을 획득하기 위해 경합
           critical section 		성공한 하나의 프로세스/스레드만 실행
           release lock				실행 후 락 반환
           remainder section
       } while (TRUE)
    예제.
```
```C
   		volatile int lock = 0; // global

   		void critical() {
   			while (test_and_set(&lock) == 1);
   			... critical section
   			lock = 0;
   		}

   		int test_and_set(int* lockPtr) {
   			int oldLock = *lockPtr;
   			*lockPtr = 1;
   			return oldLock;
   		}
```
```text
   	TestAndSet 은 CPU atomic 명령어
   		- 실행 중간에 간섭을 받거나 중단되지 않는다.
   		- 같은 메모리 영역에 대해 동시에 실행되지 않는다.
   		(multicore 에서도 CPU 레벨에서 순차적으로 실행하게 끔 동기화를 시켜서 둘 다 동시에 실행시키지 않게 한다.)
   	스핀락(spinlock)
   		락을 가질 수 있을 때 까지 반복해서 시도
   		(위의 TestAndSet() 처럼)
   		락을 기다리는 동안 CPU를 낭비한다는 단점이 있다.
   락이 준비되면 날 꺠워	(스핀락의 단점을 해결)
```
```java
   class Mutex {
       int value = 1;
       int guard = 0;
   }
   Mutex::lock() {
       while (test_and_set(&guard));
       if(value == 0) {
           ... 현재 스레드를 큐에 넣음;
           guard = 0; & go to sleep
       } else {
           value = 0;
           guard = 0;
       }
   }
   Mutex::unlock() {
       while (test_and_set(&guard));
       if(큐에 하나라도 대기중이라면) {
            그 중에 하나를 깨운다;
       } else {
            value = 1;
       }
       guard = 0;
   }
```
```C
   	mutex->lock();
   	... critical section
   	mutex->unlock();
```

```text
   	value 값을 취득해야 임계영역을 실행할 수 있다.
   	guard 공유 데이터, critical section에서 안전하게 바꿔주기 위한 장치

   	뮤텍스 (mutex)
   		락을 가질 수 있을 때 까지 휴식

   뮤텍스가 스핀락보다 항상 좋은걸까 ?
       멀티 코어 환경이고, critical section 에서의 작업이 컨텍스트 스위칭보다 더 빨리 끝난다면 스핀락이 뮤텍스보다 더 이점이 있다.
       뮤텍스는 잠들고 깨는 과정에 컨텍스트 스위칭이 발생
       스핀락은 내가 락을 쥘 수 있는지 계속 확인하기 때문
       싱글코어에서는 스핀락 방식에서 무조건 기다려야하기에 컨텍스트 스위칭이 발생해서 의미 없다.
       멀티코어에서는 한 코어가 계속 기다리고 다른 코어가 락 해제하면 바로 실행하기 때문에 컨텍스트 스위칭이 일어나지 않는다.
   semaphore(세마포)
       signal mechanism 을 가진, 하나 이상의 프로세스/스레드가 critical section에 접근 가능하도록 하는 장치
```
```java
   class Semaphore {
       int value = 1;
       int guard = 0;
   }
   Semaphore::wait() {
       while (test_and_set(&guard));
       if(value == 0) {
           ... 현재 스레드를 큐에 넣음;
           guard = 0; & go to sleep
       } else {
           value -= 1;
           guard = 0;
       }
   }
   Semaphore::signal() {
       while(test_and_set(&guard));
       if(큐에 하나라도 대기중이라면) {
           그 중에 하나를 깨워서 준비 시킨다.
       } else {
           value += 1;
       }
       guard = 0;
   }
```

```C
   	semaphore->wait();
   	... critical section
   	semaphore->signal();
```

```text
   	대기실 3개가 있을 때, 3명 이상을 받지 못할 때 사용

   	세마포는 순서를 정해줄 때도 사용할 수 있다.(signal 메커니즘을 갖는다.)
   	반드시 wait() 또는 signal() 이 같은 프로세스/스레드에서 실행할 필요가 없다.

   뮤텍스와 이진(binary) 세마포는 같은 것 아닌가 ?
       뮤텍스는 락을 가진 자만 락을 해제 할 수 있다.(누가 락을 해제할지 예상 가능) 세마포는 그렇지 않다.
       뮤텍스는 priority inheritance(여러 프로세스/스레드가 동시에 실행하면, CPU 에서 컨텍스트 스위칭이 발생해서 누구를 먼저 실행시킬지 정해야하는데 그걸 스케쥴링이라 한다.) 속성을 가진다.() 세마포는 그 속성이 없다.
   priority inheritance
       여러 프로세스/스레드가 동시에 실행하면, CPU 에서 컨텍스트 스위칭이 발생해서 누구를 먼저 실행시킬지 정하는 스케쥴링이 있다.
       스케쥴링 방식은 여러가지가 있는데, 우선순위가 높은 애들을 먼저 실행시키는 방식이 있다.
       이때, 같은 자원에 대해 경합하여 락을 취득하려한다면 프로세스 예로, 우선순위가 높은 P1과 우선순위가 낮은 P2가 있는 상황에서 P2가 락을 쥐고 있을 때
       스케쥴링이 되서 P1 이 락을 쥐려고 한다면 더이상 진행할 수 없고 P1 은 P2 에 의존성을 가지게 된다. 그렇게 P2가 락을 반환할 때까지 P1은 아무것도 할 수 없다.

       뮤텍스에서는 어떻게 해결하냐면,
       P2의 우선순위를 P1만큼 올려버린다. 그리고 P2를 먼저 실행시켜서 빨리 critical section을 통과시키게 한다.
       이렇게 P2의 우선순위를 P1의 우선순위 만큼 올리는 것을 priority inheritance라 한다.
       하지만 세마포는 이것이 없다.
   상호 배제만 필요하다면 뮤텍스를, 작업 간의 실행 순서 동기화가 필요하다면 세마포를 권장합니다.

   스핀락, 뮤텍스, 세마포의 구체적인 동작 방식은 OS와 프로그래밍 언어에 따라 조금씩 다를 수 있으니 관련 문서를 잘 읽어봐야 합니다.

6. 모니터(monitor)가 어떻게 동작하는지, 특히 자바(java)에서 어떤 형태로 사용되는지 이해
   모니터(monitor)
       - mutual exclusion을 보장
       - 조건에 따라 스레드가 대기(waiting) 상태로 전환 가능
   모니터는 언제 사용 ?
       - 한번에 하나의 스레드만 실행돼야 할 때
       - 여러 스레드와 협업(cooperating)이 필요할 때
   모니터의 구성 요소
       - mutext
           critical section에서 mutual exclusion을 보장하는 장치
           critical section에 진입하려면 mutex lock을 취득해야 함
           mutex lock을 취득하지 못한 스레드는 큐에 들어간 후 대기(waiting) 상태로 전환
           mutex lock을 쥔 스레드가 lock을 반환하면 락을 기다리며 큐에 대기 상태로 있던 스레드 중 하나가 실행
       - condition variable(s)
           waiting queue를 가짐
           조건이 충족되길 기다리는 스레드들이 대기 상태로 머무는 곳
   주요 동작(operation)
       wait : thread가 자기 자신을 condition variable의 waiting queue에 넣고 대기 상태로 전환
       signal : waiting queue에서 대기중인 스레드 중 하나를 깨움
       broadcast : waiting queue에서 대기중인 스레드 전부를 깨움
   모니터 동작
       acquire(m);					// 모니터의 락 취득
       while(!p) {					// 조건 확인
       wait(m, cv)				// 조건 충족 안되면 waiting
       }
       ... 이런 저런 코드들 ...
       signal(cv2); --OR-- broadcast(cv2);		// cv2가 cv와 같을 수도 있음(cv 가 condition variable)
       release(m);								// 모니터의 락 반환

       while 시작부터 signal() 까지 critical section, 위아래로 락 취득 반환이 있기에.
       모니터에서 한 구성요소인 mutex가 관리하는 큐, critical section에 진입과 관련된 queue라 하여 entry queue라 한다.
       condition variable에서 관리되는 큐를 waiting queue라고 한다.
       큐 안에 하나의 스레드를 깨우려면 signal(), 모두 깨우려면 broadcast()
   두 개의 큐(queue)
       entry queue : critical section에 진입을 기다리는 큐(mutex에서 관리하는 큐)
       waiting queue : 조건이 충족되길 기다리는 큐(condition variable이 관리하는 queue로서 특정 조건을 만족할 때까지 대기하는 queue)

   예제(컨슈머 프로듀서 문제)
       bounded producer/consumer problem
       bounded producer : producer는 buffer의 공간에 아이템이 가득 찼을 때, 비워져있는지 계속 확인해야하는가
       consumer problem : consumer는 buffer의 공간이 비워져 있을 때, 아이템이 있는지 계속 확인해야하는가
       이 문제를 모니터를 통해 해결 가능하다.
```
```C
   	global volatile Buffer q;
   	global Lock lock;
   	global CV fullCV;
   	global CV emptyCV;

   	public method producer() {
   		while(true) {
   			task myTask = ...;

   			lock.acquire();

   			while(q.isFull()) {
   				wait(lock, fullCV);
   			}

   			q.enqueue(myTask);

   			signal(emptyCV); --OR-- broadcast(emptyCV);

   			lock.release();
   		}
   	}


   	public method consumer() {
   		while(true) {
   			lock.acquire();

   			while(q.isEmpty()) {
   				wait(lock, emptyCV);
   			}

   			myTask = q.dequeue();

   			signal(fullCV); --OR-- broadcast(fullCV);

   			lock.release();

   			doStuff(myTask);
   		}
   	}
```
```text

   	Buffer를 공유해서 사용하기에, critical section안에서 mutual exclusion이 보장되도록 사용해야한다.
   		보장이 안되면, 동시에 여러 스레드가 버퍼에서 작업하려다가 race condition이 발생할 수 있다.
   	코드 작동
   		1. producer 또는 consumer는 락을 쥐고 있는 스레드가 없을 떄, 락을 취득한다.
   			락을 다른 스레드가 쥐고 있다면 entry queue인 lock에 대기하게 된다.
   		2. producer는 버퍼에 가득 차있다면 waiting queue인 fullCV에 대기하게 되고,
   			consumer는 버퍼가 비워져 있다면 waiting queue인 emptyCV에 대기하게 된다.
   		3. 버퍼에 적당한 아이템이 있다면 producer 또는 consumer는 signal() or broadcast()를 호출하여 entry queue에 대기중인 스레드를 깨우게 된다.
   			c1 | p2 | c2 .. 이렇게 순차적으로 큐에 쌓여있더라도 우선순위가 높은 스레드부터 작업을 하게 된다.
   		4. lock을 반환하고 consumer는 다음 작업을 수행한다.
   	중요한건
   		wait()는 while 문 안에서 동작해야한다.
   		그래서 깨어나서 락을 취득한 뒤에도 나의 조건의 충족한 상태인지 확인해야한다.

   자바에게 모니터란
       프로그래밍 언어가 지원하기에 따로 구현할 필요는 없다.
       자바에서 모든 객체는 내부적으로 모니터를 가진다.
       모니터의 mutual exclusion 기능은 synchronized 키워드로 사용한다.
       자바의 모니터는 condition variable을 하나만 가진다.
       또한 wait, notify, notifyAll 의 세가지 동작이 있다. (signal() == notify, broadcast() == notifyAll)

   bounded producer/consumer problem
```
```java
   	class BoundedBuffer {
   		private final int[] buffer = new int[5];
   		private int count = 0;

   		public synchronized void produce(int item) {
   			while(count == 5) {
   				wait();
   			}
   			buffer[count++] = item;
   			notifyAll();
   		}

   		public void consume() {
   			int item = 0;
   			synchronized (this) {
   				while(count == 0) {
   					wait();
   				}
   				item = buffer[--count];
   				notifyAll();
   			}
   			System.out.println("Consume : " + item);
   		}
   	}

   	public class Main {
   		public static void main(String[] args) throws {
   			BoundedBuffer buffer = new BoundedBuffer();
   			Thread consumer = new Thread(() -> {
   				buffer.consume();
   			});
   			Thread producer = new Thread(() -> {
   				buffer.produce(100);
   			})

   			consumer.start();
   			producer.start();

   			consumer.join();
   			producer.join();
   			System.out.println("완료");
   		}
   	}
```
```text
   	synchronized 키워드를 통해 mutual exclusion이 보장된다.
   	synchronized 키워드는 메소드 또는 블록을 이용해 사용할 수 있다.
   		블록을 사용하려면 파라미터를 하나 지정해줘야한다. 파라미터는 락을 의미한다.
   		this는 객체 자기자신(실체)를 가리킨다할 수 있다.

   	자바 모니터를 사용할 때, 두 가지 이상의 condition variable이 필요하다면 따로 구현이 필요하다.
   		자바가 제공하는 모니터를 사용하지않고 따로 구현이 필요하다.
   		java.util.concurrent에는 동기화 기능이 탑재된 여러 클래스들이 있으니 참고하시면 됩니다.

7. 데드락(deadlock)의 개념 및 OS에서 데드락을 해결하는 방법과 프로그래밍에서 해결하는 방법
   Deadlock(교착상태) : 두 개 이상의 프로세스 혹은 스레드가 서로가 가진 리소스를 기다리는 상태
   데드락을 만드는 네 가지 조건
       1. Mutual exclusion
           리소스(resource)를 공유해서 사용할 수 없다.
           한번에 하나의 프로세스만 사용 가능.
       2. Hold and wait
           프로세스가 이미 하나 이상의 리소스를 취득한(hold) 상태에서
           다른 프로세스가 사용하고 있는 리소스를 추가로 기다린다(wait)
       3. No preemption
           리소스 반환(release)은 오직 그 리소스를 취득한 프로세스만 할 수 있다.
       4.Circular wait
           프로세스들이 순환(circular) 형태로 서로의 리소스를 기다린다.
           OS의 데드락 해결 방법
           (어느 것 하나 속 시원히 해결해주는 방법은 없다)
   1. 데드락 방지
       시스템 레벨에서 디자인하는 것
           - 데드락을 만드는 네 가지 조건 중 하나가 충족되지 않게 시스템을 디자인
       1) Mutual exclusion
           - 리소스 공유 가능하게 함(현실적으로 해결하기 어려운 해결책)
       2) hold and wait
           - 사용할 리소스들을 모두 획득한 뒤에 시작
           - 리소스를 전혀 가지지 않은 상태에서만 리소스 요청
           1, 2번 리소스를 획득해야 한다면, 1번 리소스를 먼저 거칠 때 로직을 처리하고 락을 반납하고 2번을 요청하는 것으로 디자인
           단점 : a. 두 개를 모두 확보해야 출발 가능하다면, 1번 리소스를 가지고 작업하는데 오래 걸리면 2번 리소스는 놀고 있게 되다보니 효율성이 떨어짐
           b. 1, 2번 리소스가 많이 사용된다면 해당 스레드는 사용을 못하고 계속 기다리는 현상이 발생한다.(이렇게 계속 기다리는 현상을 starvation, 기아 상태라고 한다.)
       3) No preemption
           - 추가적인 리소스를 기다려야 한다면 이미 획득한 리소스를 다른 프로세스가 선점 가능하도록 한다.
           1번 리소스를 획득하고 2번 리소스를 기다리는 상황에서 다른 스레드가 1번 리소스를 기다리면 리소스를 획득할 수 있도록 양보하는 것
           CPU에서 컨텍스트 스위칭하는 것과 비슷하다. CPU에서 어떤 프로세스가 작업을 하다가 time slice를 다 쓰게 되면 자기가 할 일이 남아 있더라도 그 다음 프로세스에게 양보하게 되는 것
           모니터도 리소스를 획득했는데 특정 조건을 만족할 때까지 기다려야 한다면 자신이 critical section에 들어오면서 쥐고있던 락을 반환을 해서 다른 누군가가 critical section에 들어올 수 있도록 허용하는 것
       4) circular wait
           - 모든 리소스에 순서 체계를 부여해서 오름차순으로 리소스를 요청
           리소스의 순서체계를 만들어서 오름차순으로 요청하도록 설계
           스레드의 로직 순서가 4번 리소스를 거쳐 1번 리소스에 가도록 설계되어있다면 1번 리소스부터 획득하고 4번 리소스를 획득하도록 설계
   2. 데드락 회피
       - 실행 환경에서 추가적인 정보를 활용해서 데드락이 발생할 것 같은 상황을 회피하는 것
       Banker algorithm
       리소스 요청을 허락해줬을 때 데드락이 발생할 가능성이 있으면, 리소스를 할당해도 안전할 때 까지 계속 요청을 거절하는 알고리즘
   3. 데드락 감지와 복구
       - 데드락을 허용하고 데드락이 발생하면 복구하는 전략
       1) 프로세스를 종료한다.
           교착상태에 빠진 모든 스레드를 종료한다.
           너무 극단적이면 스레드 하나씩 종료시켜서 해결되는지 본다.(리스크가 크다)
       2) 리소스의 일시적인 선점을 허용한다
           데드락이 발생했다면, 해당 프로세스가 해당 리소스를 획득했지만 일시적으로 다른 프로세스가 해당 리소스를 획득할 수 있도록 허용한다.
   4. 데드락 무시
       아몰랑 개발자가 알아서하겠징
       프로그래밍 레벨에서 데드락(in java)
       lock 을 리소스로 이해
```
```java
   	public class Main {
   		public static void main(String[] args) {
   			Object lock1 = new Object();
   			Object lock2 = new Object();

   			Thread t1 = new Tread(()->{...});	// 아래 Thread t1 =...
   			Thread t2 = new Tread(()->{...});	// 아래 Thread t2 =...

   			t1.start();
   			t2.start();
   		}
   	}
   	Thread t1 = new Tread(()->{
   		sychronized (lock1) {
   			System.out.println("[t1] get lock1");
   			synchronized (lock2) {
   				System.out.println("[t1] get lock2");
   			}
   		}
   	})
   	Thread t2 = new Tread(()->{
   		sychronized (lock2) {
   			System.out.println("[t2] get lock2");
   			synchronized (lock1) {
   				System.out.println("[t2] get lock1");
   			}
   		}
   	})
```
```text
   	1. mutual exclusion 이 꼭 필요한지 생각해볼 것
   	2. 스레드2 도 락1을 먼저 취득하고 락2를 나중에 취득하게 변경
   	3. 락 2 안에 락 1 취득으로 중첩되게 사용하는데, 꼭 필요한 것일까 고민
```
