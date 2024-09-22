# 💡운영체제 기초
https://www.youtube.com/@ez.

```text
운영체제 기초

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
		CPU 사용률을 극대화 시키는데 목적(여러 프로세스 실행, IO 작업에만 다른 프로세스에게 CPU 작업을 넘김)
		단점
			CPU 사용 시간이 길어지면 다른 프로세스는 계속 대기
		해결책
			프로세스는 한번 CPU를 사용할 때, 아주 짧은 시간(=quantum,)만 CPU에서 실행되도록 하자!
			(양자(量子, 영어: quantum, 복수형 quanta)는 더 이상 나눌 수 없는 에너지의 최소량의 단위로)

	멀티태스킹(multitasking, 멀티 프로그래밍의 해결책)
		프로세스의 응답 시간을 최소화 시키는데 목적(마치 여러 프로그램이 동시에 실행되는 느낌, 실행 시간을 작게 쪼개서 번갈아 가며 실행)
		단점
			하나의 프로세스가 동시에 여러 작업을 수행하지는 못함(멀티 태스킹까지는 여러 프로세스를 실행시키는데 목적이였다.)
			프로세스의 컨텍스트 스위칭은 무거운 작업(컨텍스트 스위칭 : 프로세스 교체작업)
			프로세스끼리 데이터 공유가 까다로움(두개의 프로그램의 메모리 공간이 독립적으로 나뉘어져 공유가 까다로움)
			듀얼 코어가 등장했는데, 잘 쓰고 싶음
		해결책
			쓰레드

	쓰레드 특징
		프로세스는 한 개 이상의 스레드를 가질 수 있다.(한 프로세스위에 여러 작업을 동시에 실행하기 위함)
		CPU에서 실행되는 단위(unit of execution)
			전에는 프로세스가 CPU에서 실행되는 단위였다.
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
				(이때 프로세스에서 커널로 통제권이 넘어가서 커널에 의해 실행되는 것을 커널 모드라고 한다.)
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
		파일을 읽고 쓰거나 네트워크의 어딘가와 또는 입출력 장치와 데이터를 주거나 받는 것
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
	하나의 객체에 두 개의 스레드가 접근할 때 생긴일
		for..
			count();		코드 실행

		LOAD state to R1	운영체제 명령어, 여러 복합문의 명령어
		R1 = R1 + 1 		연산
		STORE R1 to state	메모리 상태값 변경

		스레드 1,2이 실행되며 메모리 state 값을 2로 기대하지만,
		연산과정에서 컨텍스트 스위칭으로 인해 스레드 2는 스레드 1의 값이 반영되지 않은 상태에서 연산되기에 메모리 state 값이 1로 나올 수 있다.

	race condition(경쟁 조건)
		여러 프로세스/스레드가 동시에 같은 데이터를 조작할 때,
		타이밍이나 접근 순서에 따라 결과가 달라질 수 있는 상황.
	동기화(synchronization)	
		여러 프로세스/스레드가 동시에 실행되도 공유 데이터의 일관성을 유지하는 것
	어떻게 동기화 시킬 것인가 ?
		해당 명령어를 실행할 땐, 컨텍스트 스위칭을 막아버린다.
			싱글 코어에서만 가능, 각 코어마다 다른 스레드 보유
		count() 실행 시, 한 스레드만 실행 가능하게 한다.
	critical section(임계 영역, critical section problem)
		공유 데이터의 일관성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역

		do {
			entry section 			(critical section 진입 요건 확인)
				critical section
			exit section 			(이후에도 섹션이 잘 작동하도록 조치를 취함)
				remainder section
		} while (TRUE)

	critical section problem의 해결책이 되기 위한 조건
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
			volatile int lock = 0; // global

			void critical() {
				while (test_and_set(&lock) == 1); 	(while loof를 통해 락 획득 시도, 최초 실행에서는 공유자원이 0이기에 false로 탈출하게 된다.)
				... critical section 				(획득에 성공한 스레드가 섹션 진입)
				lock = 0;
			}

			int test_and_set(int* lockPtr) { 
				int oldLock = *lockPtr; 		(공유되는 락에 대해서 그 락이 원래 가지고 있던 값을 가져와서)
				*lockPtr = 1;					(반환 하기 전에 그 값을 무조건 1로 바꿔주어라)
				return oldLock; 				(원래 가지고 있던 값을 반환)
			}
		TestAndSet 은 CPU atomic 명령어
			- 실행 중간에 간섭을 받거나 중단되지 않는다.
			- 같은 메모리 영역에 대해 동시에 실행되지 않는다.
			(multicore 에서도 CPU 레벨에서 순차적으로 실행하게 끔 동기화를 시켜서 둘 다 동시에 실행시키지 않게 한다.)
		스핀락(spinlock)
			락을 가질 수 있을 때 까지 반복해서 시도(CPU 낭비)
			(위의 TestAndSet() 처럼)
			락을 기다리는 동안 CPU를 낭비한다는 단점이 있다.
	락이 준비되면 날 꺠워	(스핀락의 단점을 해결)
		class Mutex {
			int value = 1;	(value 값을 취득해야만 critical section 을 수행할 수 있다.)
			int guard = 0; 	(critical section영역 안에서도 안전하게 value 값을 바꿔주기 위한 장치)
		}
		Mutex::lock() {
			while (test_and_set(&guard)); 	(guard를 취득하기 위해 경합, 이기면 다음 로직을 수행하고 0으로 변환)
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

		mutex->lock();
		... critical section
		mutex->unlock();

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

		semaphore->wait();
		... critical section
		semaphore->signal();

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
	모니터의 구성 요송
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

		1. mutual exclusion 이 꼭 필요한지 생각해볼 것
		2. 스레드2 도 락1을 먼저 취득하고 락2를 나중에 취득하게 변경
		3. 락 2 안에 락 1 취득으로 중첩되게 사용하는데, 꼭 필요한 것일까 고민

8. OS 프로세스의 상태(state) 변화를 이해하게 되고 자바 스레드의 상태와는 어떻게 다른지 알게 됩니다.
	OS 에서 프로세스 상태(state)
		1. new (프로세스 생성, 기다림)
		2. ready 상태로 변경되서 CPU 에 실행할 준비(처음 프로세스 생성되면 바로 ready 상태로 변경)
		3. scheduler 에 의해서 자신의 차례가 되면 running 상태가 되고 CPU 에서 이런저런 실행
		4. 자신에게 할당된 time slice를 다 쓰게되면 다시 ready 상태
		5. I/O 또는 critical section 을 기다릴 때, waiting 상태
		6. 실행할 상태가 된다면 ready 상태로 기다리다가 running 상태로 변경되고 CPU 에서 실행
		6. 프로세스가 종료되면 terminated 상태
	쓰레드의 상태 변화는 메모리를 공유하는 프로세스이기에 위의 상태와 거의 동일하다.
	위 설명은 운영체제마다 살짝 다를 수 있다

	Java thread의 상태 종류
		NEW
			자바 스레드가 아직 시작하지 않은 상태
		RUNNABLE
			실행 중인 상태(CPU 실행)
			다른 리소스를 기다리는 상태도 포함
			IO 결과를 기다리는 상태도 포함	
		BLOCKED
			모니터 락을 얻기 위해 기다리는 상태
			critical section 으로 들어가기 위해 모니터 락을 얻기 위해 기다리는 상태
		WAITING
			다른 스레드를 기다리는 상태(언제 스레드가 waiting 상태가 되는지는 자바 공식 문서에서 코드레벨로 자세히 설명)
			Object.wait <- 모니터 관련, wait() 호출하면 wait 상태로 변경
			Tread.join <- join() 호출, wait 상태로 변경
			...
		TIMED_WAITING
			제한 시간을 두고 다른 스레드를 기다리는 상태
			Object.wait with timeout <- timeout 을 파라미터로 wait() 메소드에 전달
			Tread.join with timeout <- timeout 을 파라미터로 join() 메소드에 전달
			Tread.sleep <- sleep() 호출
			...
		TERMINATED
			실행을 마치고 종료된 상태

		예.	(모니터와 관련된 자료에서 사용된 코드	)
		class BoundedBuffer {
			private final int[] buffer = new int[5];
			private int count = 0;

			public synchronized void produce(int item){	// synchronized 모니터 관련, 모니터 안에 뮤텍스 
				while(count == 5) { wait(); }
				buffer[count++] = item;
				notifyAll();
			}

			public void consume() {
				int item = 0;
				synchronized (this) {
					while (count == 0) { wait(); }
					item = buffer[--count];
					notifyAll();
				}
				System.out.println("Consume : " + item);
			}
		}

		public class Main {
			public static void main(String[] args) throws {
				BoundedBuffer buffer = new BoundedBuffer();

				Tread consumer = new Tread(() -> {
					buffer.consume();
				})
				Tread producer = new Tread(() -> {
					buffer.producer(100);
				})

				consumer.start();
				producer.start();

				consumer.join();
				producer.join();
				System.out.println("완료");
			}
		}

		상태 변화
		1. 
			public synchronized void produce(int item){	// synchronized 모니터 관련, 모니터 안에 뮤텍스 
				while(count == 5) { wait(); }
				buffer[count++] = item;
				notifyAll();
			}
			만들어지며 new 상태가 되며

		2. consumer.start(); 통해 runnable 상태

		3. 
			public void consume() {
				int item = 0;
				synchronized (this) {
					while (count == 0) { wait(); }
			wait(); 메소드를 통해 waiting 상태

		4. producer.start(); 통해 runnable 상태

		5. 
			public synchronized void produce(int item){	// synchronized 모니터 관련, 모니터 안에 뮤텍스 
				while(count == 5) { wait(); }
				buffer[count++] = item;
				notifyAll();
			}
			실행	

		6. 5의 notifyAll() 를 통해 waiting 상태였던 consumer 는 깨어나고 모니터 락을 아직 쥔 상태가 아님
			그래서 runnung 이 아닌 blocked 상태

		7. producer 는 실행을 마치고 synchronized void produce() 메서드를 탈출, 모니터 락을 반환

		8. consumer 는 락을 얻고 runnable 상태로 변경, public void consume() 메서드 탈출

		9. consumer 상태는 terminated 상태로 변경

	Java Tread dump
		Thread dump
			실행 중인 자바 프로세스의 현재 상태를 담은 스냅샷
			해당 프로세스에 속한 여러 스레드들의 상태를 알 수 있다.
		Java 로 개발된 API 서버를 운영중에 있는데, 자바 API 의 서버의 스레드를 거의 사용해버리고 새로운 API 의 요청에 대해 응답을 제대로 못하는 상황.
		종종 서버의 터미널로 접근해서 해당 자바 인스턴스의 스레드 덤프를 뜨고 그 스레드 덤프를 분석.
		어디를 보고 상태 분석.
		데드락이면 대부분 블락이나 웨이팅 상태.

9. CPU scheduler와 dispatcher 차이의 이해와 스케줄링의 선점 방식과 다양한 스케줄링 알고리즘
	CPU scheduler vs Dispatcher
		scheduler : CPU에서 실행될 프로세스를 선택하는 역할
			CPU가 항상 놀지 않고 일을 할 수 있도록 프로세스를 "선택"하는 역할
			ready 상태에 있는 프로세스들을 모아 놓은 큐가 ready queue라고 하는데,
				CPU 에서 실행되길 원하는 프로세스들이 기다리고 있다.
			scheduler는 ready queue에서 다음 번에 어떤 프로세스가 CPU에서 실행되야 할 지를 선택하는 역할을 한다.
		dispatcher : 선택된 프로세스에게 CPU를 할당하는 역
			scheduler가 선택한 프로세스가 실제로 CPU에서 실행될 수 있도록 만드는 역할
			context switching 역할을 한다. context switching은 괼장히 민감한 동작이므로 커널모드에서 실행된다.
			끝이나고 새로운 선택된 프로세스가 실행될 수 있도록 유저모드로 전환이 된다. 컨트롤을 새롭게 선택된 프로세스에게 넘겨준다.
			새롭게 선택된 프로세스가 어디서부터 작업을 시작해야할지. 실행되야할 적절한 위치로 이동시킨다.
	스케줄링의 선점 방식
		Nonpreemptive scheduling vs Preemptive scheduling
			Nonpreemptive(비선점) scheduling : 신사적, 협력적(cooperative, 코루틴에서도 이 개념이 나오기에 중요하다), 느린 응답성(신사적으로 기다려주기 때문에, 오래 사용하고 있으면 계속 ready queue에서 기다리고 있을 것이다.)
				종료(exit, terminated 상태) 또는 I/O(waiting 상태), 자발적으로 양보(ready 상태)로 이 세가지에 대해 OS에서 개입을 해서 스케쥴링을 하는 것
				비선점이란 프로세스가 자발적으로 running 상태에서 빠져나가기 때문.
			Preemptive(선점) scheduling : 적극적, 강제적, 빠른 응답성, 데이터 일관성 문제(이러한 문제들로 인해 크리티컬 섹션, 뮤텍스 락을 만들고 등등 작업을 한다.)
				Nonpreemptive scheduling이 하는 일은 기본적으로 다 한다,
				그리고 추가적으로 프로세스가 CPU에서 실행이 다 끝나지 않았음에도 개입하는 경우가 있다.
					예를 들어
					1. 어떤 프로세스가 CPU에서 실행중(running 상태)인데,
						(멀티 태스킹)time slice를 다 쓰게 되면, 아직 CPU에서 작업이 끝나지 않아도 ready 상태(ready queue)로 돌아가야 한다.
						이런 경우에 운영체제가 개입해서 ready queue에 집어 넣는 작업
					2. waiting 상태의 프로세스가 만약 IO 작업이 끝나서 ready 상태가 되었을 때
						ready 상태가 된 프로세스가 CPU에서 실행되고 있는 프로세스보다 우선순위가 더 높다면,
						우선순위가 높은 프로세스를 바로 CPU 에서 실행 시켜야 하기에 이미 CPU에서 실행되고 있던 프로세스가 ready 상태로 가게 끔 스케쥴러가 개입
					결론 : running 상태에서 프로세스가 실행하고 있는데, 충분히 CPU를 다 쓰지 않았음에도 강제로 ready로 바꿔줌
	스케줄링 알고리즘 : ready queue에서 기다리고 있는 프로세스들을 어떤 알고리즘, 기준으로 선택할 것인지에 대한 내용
		FCFS(first-come, first-served) : 먼저 도착한 순서대로 처리(큐방식)
		SJF(shortest-job-first) : 프로세스의 다음 CPU burst가 가장 짧은 프로세스부터 실행
		SRTF(shortest-remaining-time-first) : 남은 CPU burst가 가장 짧은 프로세스부터 실행
		Priority : 우선순위가 높은 프로세스부터 실행
			Nonpreemptive, Preemptive 방식에 따라 다르다.
		RR(round-robin) : time slice로 나눠진 CPU time을 번갈아가며 실행(멀티 태스킹 방식과 가장 유사한 방식)
		Multilevel queue : 프로세스들을 그룹화해서 그룹마다 큐를 두는 방식

10. 유저 모드, 커널 모드, 인터럽트, 시스템 콜의 의미와 프로그래밍 언어와의 관계 이해
	User mode & Kernel mode
		User mode : 우리가 개발하는 프로그램은 일반적으로 유저 모드에서 실행

		User mode -> kernel mode : 프로그램 실행 중에 인터럽트(interrupt)가 발생하거나 시스템 콜(system call)을 호출하게 되면 커널 모드로 전환

		Kernel mode : 프로그램의 현재 CPU 상태를 저장함
			커널이 인터럽트나 시스템 콜을 직접 처리. 즉, CPU에서 커널 코드가 실행됨
			처리가 완료되면 중단됐던 프로그램의 CPU 상태를 복원

		Kernel mode -> User mode : 다시 통제권을 프로그램에게 반환

		User mode : 프로그램이 이어서 실행됨

	커널(Kernel)
		- 운영체제의 핵심
		- 시스템의 전반을 관리/감독하는 역할
		- 하드웨어와 관련된 작업을 직접 수행
		존재 이유 : 시스템을 보호하기 위해
			개발한 프로그램이 함부러 하드웨어를 모두 점유해서 사용하여 다른 프로세스에 영향이 가던가 전체 시스템에 영향이 갈 수 있음

	Interrupt : 시스템에서 발생한 다양한 종류의 이벤트 혹은 그런 이벤트를 알리는 메커니즘
		종류
		- 전원(power)에 문제가 생겼을 때
		- I/O 작업이 완료됐을 때
		- 시간이 다 됐을 때(timer H/W 관련)
		- 0으로 나눴을 때(프로그램 레벨, 그래서 interrupt 대신 trap 이라고 불리기도 함)
		- 잘못된 메모리 공간에 접근을 시도할 때(프로그램 레벨, 그래서 interrupt 대신 trap 이라고 불리기도 함)
		... 등등

	인터럽트가 발생하면 CPU에서는 즉각적으로 인터럽트 처리를 위해 커널 코드를 커널 모드에서 실행
		즉각적으로 란 인터럽트가 언제든 발생할 수 있기에 실행중인 명령어를 마무리하고 인터럽트 처리를 위해 커널이 통제권을 넘겨받아 관련 처리를 한다.

	System call : 프로그램이 OS 커널이 제공하는 서비스를 이용하고 싶을 때 시스템 콜을 통해 실행
		종류
		- 프로세스/스레드 관련
		- 파일 I/O 관련
		- 소켓 관련(네트워크 관련)
		- 장치(device) 관련
		- 프로세스 통신 관련(프로세스 끼리 통신)

	시스템 콜이 발생하면 해당 커널 코드(시스템 콜에 대응하는 각각의 커널 코드가 있다)가 커널 모드에서 실행

	시스템 콜 & 인터럽트 : 어떻게 사용되는지, 유저모드에서 커널모드로 어떻게 전환되는지 (파일을 read 할 때의 예제 상황)
		유저모드
			- 스레드1이 running 상태에서 file을 read 하기 위해, read 라는 시스템 콜을 호출하는 순간 커널 모드로 전환. 스레드2 ready 상태
		커널모드 전환
			- 스레드1 cpu 상태 저장
			- 파일 읽을 준비(IO 작업관련이고 SSD로부터 파일을 읽어 오려는 작업이기에 파일의 위치를 찾아서 파일에서 읽으려는 내용을 buffer에서 읽을 수 있도록 준비시키는 작업을 한다.(SSD 관련 작업))
			- 스레드1 상태를 waiting 상태로 변경, 스레드2 running 상태로 변경
		유저모드 전환
			- 통제권은 스레드2로 넘어옴
			- 스레드1이 요청했던 파일을 읽을 준비가 완료 됬다는 것을 interrupt를 통해 알려준다, 그러면 다시 커널모드로 전환
		커널모드 전환
			- 스레드2 cpu 상태 저장, 스레드1 ready 상태로 변경
			- 스레드2 cpu 상태 복원하고 통제권을 유저모드에 넘겨(유저모드 전환)준다.
		유저모드 전환
			- 멀티 태스킹 방식이기 때문에 주어진 time slice를 다 사용하고 time 이라는 H/W를 통해 시간을 모두 사용한 것을 interrupt를 통해 알려준다
			- timer와 관련된 interrupt가 발생하면 다시 커널모드로 전환된다.
		커널모드 전환
			- 스레드2 cpu 상태 저장, 스레드2 ready 상태로 변경, 스레드1 running 상태로 변경, 스레드1 cpu 상태 복원


		다시 처음부터 똑같이 반복..

	프로그래밍 언어와 시스템 콜
		하드웨어 혹은 시스템 관련 기능은 어떤 프로그램이라도 반드시 시스템 콜을 통해서만 사용 가능
		하지만 보통 우리는 개발할 때 직접 OS 시스템 콜을 사용한 적이 없죠.
		그럼에도 우리는 지금까지 파일 I/O, 네트워크 I/O, 프로세스/스레드 관련 작업을 해왔습니다.
		어떻게 가능했던걸까
			이것은 우리가 사용하는 프로그래밍 언어들이 시스템 콜을 포장(wrapping)하여 간접적으로 사용할 수 있도록 제공했기 때문

		java.lang.Thread class

		Thread thread = new Thread();
		thread.start();
		// 시스템 콜을 반드시 필요로 하는 작업

		public synchronized void start() {
			...
			boolean started = false;
			try {
				start0();
				started = true;
			} finally {...}
			...
		}
		private native void start0();	// native 키워드는 JNI(Java Native Interface)를 통해서 기반이 되는 OS의 시스템 콜을 호출
										// 리눅스 기반이라면 clone 이라는 시스템 콜을 호출하는 것으로 볼 수 있다.

		하이레벨 프로그램 언어가 이 시스템 콜을 호출할 수 있도록 래핑해서 제공하고, 개발자는 간접적으로 시스템 콜을 사용할 수 있다.

11. 하드웨어, OS, 네이티브, 커널, 유저, 그린 스레드 개념의 이해
	Hardware thread
		코어(core)의 고민 : 메모리에서 데이터를 기다리는 시간이 꽤 오래 걸린다(코어에서 실행되는 연산작업보다 메모리에서 기다리는 시간이 더 오래 걸린다. 코어낭비)
			메모리를 기다리는 동안, 다른 스레드를 실행하는건 어떻까?
				코어가 연산 작업을 하다가 메모리에서 읽어오든 결과를 반영하든 메모리에 접근하면 코어는 일을 하지않게 된다.
				그래서 메모리에 접근하는 동안에 독립적으로 다른 작업을 하게 하는 방식
				결론은 두 개의 서로 다른 H/W Thread 를 사용한다고 한다.
			인텔에서는 hyper-threading 이라고 브랜딩을 했다 : 물리적인 코어마다 하드웨어 스레드가 두개
			Hardware thread : OS 관점에서는 가상의(logical) 코어
				만약에 싱글 코어 CPU에 하드웨어 스레드가 두 개라면 OS는 이 CPU를 듀얼 코어로 인식하고 듀얼 코어에 맞춰서 OS 레벨의 스레드들을 스케줄링 한다.
	OS thread(일반적으로 알고 있던 스레드 개념)
		커널(kernel) : 
			- 운영체제의 핵심
			- 시스템의 전반을 관리/감독하는 역할
			- 하드웨어와 관련된 작업을 직접 수행
		OS 스레드 
			- OS 커널 레벨에서 생성되고 관리되는 스레드
			- CPU에서 실제로 실행되는 단위
			- CPU 스케줄링의 단위
			- OS 스레드의 컨텍스트 스위칭은 "커널"이 개입 -> 비용 발생
			- 사용자 코드와 커널 코드 모두 OS 스레드에서 실행된다
		OS 스레드는 아래와 같이 불리기도 한다
			- 네이티브(native) 스레드 (보통 네이티브라고 하면 OS 개념)
			- 커널 스레드* (다른 의미로도 불린다)
			- 커널-레벨 스레드
			- OS-레벨 스레드

		OS 스레드 여덟 개가 하이퍼 스레딩이 적용된 인텔 듀얼코어 위에서 동작한다면
		OS 스레드들을 어떻게 코어에 균등하게 할당할 수 있을까요 ?
			물리적인 CPU 2개, 가상 스레드 4개, OS 스레드 두 개씩 가상 스레드에 할당
	User thread
		유저 스레드는 유저-레벨 스레드라고 불리기도 한다
		유저 스레드 : 스레드 개념을 프로그래밍 레벨에서 추상화 한 것
		Thread thread = new Thread();
		thread.start();	// start0() JNI 에서 OS kernel 의 system call 호출, 리눅스면 clone 호출되고 os level thread 생성
		유저 스레드가 CPU에서 실행되려면 OS 스레드와 반드시 연결돼야 한다
		유저 스레드와 OS 스레드를 어떻게 연결시킬 것인가 ?
			One-to-One model (오늘날의 java의 예)
				유저 스레드와 OS 레벨의 스레드가 1:1로 연결되는 모델
				스레드 관리를 OS에 위임 (스케줄링 포함, 커널이 수행)
				멀티코어 활용 (CPU가 멀티 코어를 가진다 하더라도 멀티 코어의 OS 스레드를 잘 배분 시켜서 동작 시킬 것이다.(1:1 매핑되는 유저 코어도 멀티코어로 잘 활용된다))
				한 스레드는 블락되어도 다른 스레드는 잘 동작 (유저 스레드가 block I/O 를 실행한다면 OS 레벨 스레드도 block I/O 실행, 해당 스레드는 blocking이 되어 기다리게 되지만 다른 스레드들은 상관 없이 잘 동작한다.)
				race condition 가능성
			Many-to-One model
				여러 유저 스레드가 하나의 OS 스레드에 연결되는 모델
				유저 스레드 간의 스위칭이 빠름 (컨텍스트 스위칭 작업을 커널이 개입하지 않기 때문에 컨텍스트 스위칭이 훨씬 더 빠르게 끝날 수 있다)
				race condition 가능성이 적다
				멀티 코어 활용을 못한다.
				한 스레드가 블락 -> 모든 스레드들 블락 => 그래서 non block io 사용 (유저 스레드 하나가 block I/O 작업을 하면 커널 레벨의 스레드도 block I/O 를 실행하고 연결되어 있는 나머지 유저 스레드들 전부도 blocking이 된다.)
			Many-to-Many model
				다수의 유저 스레드와 다수의 OS 스레드들의 연결
				One-to-One, Many-to-One model의 장점을 합친 것 이다.
				유저 스레드들간의 스위칭이 빠르면서도 멀티 코어를 활용하게 되고, 하나가 블락이 되도 전체 유저 스레드가 블락이 되지 않는다. (Go 언어에서 지원)
			스레딩(threading) 모델
				유저 스레드(user thread) : OS와는 독립적으로 유저 레벨에서 스케줄링되는 스레드
	Green thread
		Java 초창기 버전은 Many-to-One 스레딩 모델을 사용, 이 때 이 유저 스레드들을 그린 스레드라고 호칭(이전에 사용된 의미)
		OS와는 독립적으로 유저 레벨에서 스케줄링되는 스레드(오늘날은 확장되어 Many to One, Many to Many model 의 유저 스레드를 호칭)
		맥락에 따라 유저 스레드와 그린 스레드를 같은 의미로 사용하기도 한다.
	조금 다른 맥락에서 Kernel thread
		Kernel thread : OS 커널의 역할을 수행하는 스레드
	유저 레벨에서 스케줄링되는 스레드는 나중에 배울 코루틴(coroutine)과 관련이 있으니 잘 기억해 주자 !

12. 스레드 풀(thread pool) 개념과 사용할 때 팁
	Thread per request model
		API에 요청이 들어오면 request와 스레드를 1:1 매핑해서 하나의 request를 하나의 스레드가 처리하는 방식
		만약 thread per request 모델의 동작 방식이 서버에 들어오는 요청마다 스레드를 새로 만들어서 처리하고 처리가 끝난 스레드는 버리는 식으로 동작한다면 어떤 문제가 있을까?
			스레드 생성에 소요되는 시간 때문에 요청 처리가 더 오래 걸림
			처리 속도보다 더 빠르게 요청이 늘어나면
				- 스레드가 계속 생성 (스레드 수 증가)
					-> 메모리가 점점 고갈됨
				- 컨텍스트 스위칭이 더 자주 발생
				- CPU 오버헤드 증가로 CPU time 낭비
				- 어느 순간 서버 전체가 응답 불가능 상태에 빠짐
		위의 문제를 해결하기 위해 Tread pool 개념 등장
			미리 스레드를 제한된 개수 만큼 생성해 놓고, request는 스레드 풀에서 내부적으로 관리하는 queue에 들어오게 된다.
				큐에 들어온 요청은 놀고 있는 스레드에게 할당이 된다.
			미리 스레드를 여러 개 만들어 놓고 재사용
				-> 스레드 생성 시간 절약
			제한된 개수의 스레드를 운용
				-> 스레드가 무제한 생성되는 것을 방지
			thread pool 사례 : 여러 작업을 동시에 처리해야할 때
				- thread per request 모델
				- task를 subtask로 나뉘어서 동시에 처리(예. 몇천억개 되는 아이템의 가격을 모두 더하고 싶을 때, subtask로 나눠서 동시에 처리 가능. subtask로 나눠진 아이템들을 동시에 각 가격을 합산하고 최종적으로 합치는 방식)
				- 순서 상관없이 동시 실행이 가능한 task 처리
	Tread pool 사용 팁
		1. 스레드 풀에 몇 개의 스레드를 만들어 두는 게 적절한가 ?
			CPU 코어 개수와 task의 성향에 따라 다름
			- CPU-bound task 라면, 코어 개수 만큼 혹은 그 보다 몇 개 더 많은 정도
			- I/O-bound task 라면, 코어 개수보다 1.5배? 두 배? 세 배? 경험적으로 찾아야 함
		2. 스레드 풀에서 실행될 task 개수에 제한이 없다면 "스레드 풀의 큐가 사이즈 제한이 있는지 꼭 확인할 것 !"
			큐에 요청이 무한정 쌓인다면 ?
				남는 스레드가 없고 큐에 요청들이 계속 쌓이는 상황인데, 이 큐 사이즈에 제한이 없다면 요청이 계속 쌓인다.(잠재적으로 메모리를 고갈시킬 수 있는 위험 요소가 될 수 있)
				제한이 있는지 확인하고, 반드시 제한을 둬야한다.(나머지 요청을 버리더라도 서버를 위해 해야할 작업)
				CAUTION! 자바의 Executors 클래스
					static 메서드로 다양한 형태의 스레드 풀을 제공
					ExecutorService threadPool = Executors.newFixedTreadPool(10);
					threadPool.submit(task1);
					threadPool.submit(task2);

					public static ExecutorService newFixedTreadPool(int nThreads) {	// 매개변수, 스레드 개수
						return new TreadPoolExecutor(nThreads, nThreads
								, 0L, TimeUnit.MILLISECONDS
								, new LinkedBlockingQueue<Runnable>());
					}
					public LinkedBlockingQueue() {
						this(Integer.MAX_VALUE);	// 20억 쯤 됨.
					}
					public LinkedBlockingQueue(int capacity) {	// 매개변수, 큐 사이즈
						if(capacity <= 0) throw new IllegalArgumentException();
						this.capacity = capacity;
						last = head = new Node<E>(null);
					}

					// Integer.MAX_VALUE 20억 쯤되는데 이것을 사이즈로 정한다는 것은, 제한이 없다는 말이다.
	Pool이라는 개념은 스레드에만 쓰이는 것은 아닙니다
		connection pool - tcp connection을 만들 때도 시간이 소요되어 미리 만들어 두는 것
		process pool - 프로세스를 여러개 미리 만들어 놓는 

13. block I/O와 non-block I/O의 개념과 이해
	I/O : input/output, 데이터의 입출력
		종류 : network(socket), file, pipe(process 간 통신에 사용되는 개념), device(모니터, 키보드)
	socket : 네트워크 통신은 socket을 통해 데이터가 입출력 된다
	backend server : 네트워크 상의 요청자들과 각각 소켓을 열고 통신한다

	block I/O와 non-block I/O의 동작 원리를 OS 레벨에서의 개념으로 네트워크 I/O를 예로 설명
		block I/O : I/O 작업을 요청한 프로세스/스레드는 요청이 완료될 때까지 블락됨
			스레드에서 코드가 실행이 되다가 read blocking system call 을 호출하고 block이 된다
			커널 모드로 전환이 되고, read i/o 실행(관련 device에서 실행)하고 시간이 지나 read response. data moved from kernel space to user space.
			Socket에서 block I/O 란 ?
				소켓 마다 두 개의 버퍼가 있다. send_buffer, recv_buffer
				1. read : read system call을 socket에 대고 호출하면 recive buffer에 데이터가 들어올 때 까지 read system call을 호출한 스레드는 블락이 된다.(recive buffer에 데이터가 들어올 때 까지 블락)
				2. write : send buffer가 가득 차있을 때, 블락이 된다.(send buffer의 공간이 생길 때 까지)
		
		non-block I/O : 프로세스/스레드를 블락시키지 않고 요청에 대한 현재 상태를 "즉시 리턴", 그렇기에 스레드가 다른 작업을 수행할 수 있
			스레드가 read non-blocking system call 호출하는 순간 kernel mode 로 context switching되고 커널에서 initiate read I/O 작업 실행
			그리고 커널에서 바로 리턴, 리눅스 기준 -1 값을 리턴하고 동시에 EAGAIN or EWOULDBLOCK의 에러코드 둘 중 하나를 같이 리턴
			non-block io 이기에 이어서 다른 코드도 실행할 수 있다. 그러는 동안에, I/O device로부터 읽을 준비가 되었다는 응답이 커널로 오게되고 커널은 데이터를 준비해 둔다.
			스레드는 또 read non-blocking system call 호출하게되고 kernel mode 로 context switching되고
			준비 되어 있던 데이터, data moved from kernel space to user space.
			Socket에서 non-block I/O 란 ?
				소켓 마다 두 개의 버퍼가 있다. send_buffer, recv_buffer
				1. read : recv_buffer에 데이터가 있는지 read로 확인, 데이터가 없다면 없다고 알려주고 read system call은 바로 종료
				2. write : send_buffer에 데이터가 가득차있다면, block 시키지 않고 적절한 에러코드와 함께 write system call을 반환시킨다.
			I/O 작업 완료를 어떻게 확인할 것인가 ?(non-block i/o 결과 처리 방식)
				1. 완료됐는지 반복적으로 확인
					문제 : 완료된 시간과 완료를 확인한 시간 사이의 갭으로 인해 "처리 속도가 느려질 수 있음"
					확인에 대한 read response를 반환과 데이터 반환에 대한 system call 요청 사이의 딜레이가 발생
					완료됐는지 반복적으로 확인은 "CPU 낭비가 발생"
				2. I/O multiplexing(다중 입출력) 사용
					관심있는 I/O 작업들을 동시에 "모니터링"하고 그 중에 완료된 I/O 작업들을 "한번에 알려줌"
					스레드는 I/O multiplexing system call을 커널에 요청. 이때 monitor 2 socket non-blocking read(2개의 소켓에 대해 논블락킹 모드로 읽으려니까 새로 들어오는 데이터가 있는지 알려주세용)
					initiate read I/O, initiate read I/O 작업(소켓 두 개) 요청을 network device에 보냄
					I/O multiplexing system call을 호출한 스레드는 block이 될 수도 있고 어떻게 호출하느냐에 따라 또 다른 코드를 실행할 수도 있다.
					(블라킹모드로 동작으로 설명)
					두 소켓에 데이터가 들어오고 network device로 부터 read response를 받게 되고, 커널에서 데이터가 있다는 것을 알려주게 된다
					스레드는 블라킹 모드에서 깨어나고 순차적으로 read non-blocking system call 요청 > data moved 두 번 실행
					종류
						- select(성능이 좋지 않아 잘 쓰이지 않음)
						- poll(성능이 좋지 않아 잘 쓰이지 않음)
						- epoll(리눅스)
							각 socket이 epoll을 통해서 하나라도 read이벤트가 생기면 알려주게 만듦
						- kqueue(mac)
						- IOCP(I/O completion port)(window, solaris)
					I/O multiplexing은 네트워크 통신에 많이 사용된다. 톰켓 등 이미 잘 되어있어서 직접 만들 필요는 없지만 개발하다보면 활용할 일이 생길 수 있으니 알고 있자
				3. Callback/signal 사용
					스레드가 aio_read non-blocking system call > kernel 에서는 initiate read I/O
					read response가 오면 callback or signal로 처리
					종류
						- POSIX AIO (여러 운영체제에서 표준화되어 사용할 수 있는 명세서 같은 것. 그 안에 정의된 AIO를 통해 사용)
						- LINUX AIO
						널리 사용되지는 않는 것 같음
				4. 그 외..
					io_uring (linux에서는 새롭게 추가됨, file io 에서 장점인듯)
	핵심은 non-block I/O를 통해 I/O 요청 완료 전에도 다른 일을 할 수 있다는 것 !

14. 관점에 따른 asynchronous의 다양한 개념
	programming 관점
		Synchronous(동기)
			|	task1	|	task2	|	task3	|
			synchronous programming : 여러 작업(task)들을 순차적으로 실행하도록 개발
		Asynchronous(비동기)
			|	task1	|
			  |	task2	  |
			 |	task3	 |
			asynchronous programming : 여러 작업들을 독립적으로 실행하도록 개발
				여러 작업을 동시에 실행하는 프로그래밍 방법론
			multithreading : asynchronous programing의 한 종류
			asynchronous programing을 가능하게 하는 것은
				- multi-threads
					thread1		|	task1	|	task2	|
					thread2		|	task3	|	task4	|
				- non-block I/O
					thread		|	task1	|
								  |	task2	  |
								 |	task3	 |
			백엔드 프로그래밍의 추세는 스레드를 적게 쓰면서도 non-block I/O를 통해 전체 처리량을 늘리는 방향으로 발전 중
	I/O 관점
		case1
			synchronous I/O = block I/O
			asynchronous I/O = non-block I/O
		case2
			synchronous I/O : 요청자가 I/O 완료까지 챙겨야 할 때
			asynchronous I/O : 완료를 noti 주거나 callback으로 처리
		case3
			asynchronous I/O : block I/O를 다른 thread에서 실행
	백엔드 아키텍처 관점
		하나의 서비스는 기능과 역할에 따라 여러 개의 마이크로 서비스로 구성되고 이들 사이에는 빈번하게 커뮤니케이션이 발생합니다.
			synchronous communication
				A service 					B service  					C service
								->
						API call : send event		
															->
													API call : send event
				만약 C에서 응답 불능상태에 빠지면 B, A Service에도 응답 불능 문제가 생겨서 서비스 전체가 장애가 확대될 수 있다.
				이러한 문제로 인해 비동기로 동작시키는 것이 좋다.
			asynchronous communication
				A service 					B service  					C service
				produce event
						->	Message Q 	->
											comsume event
											produce event
														->	Message Q 	->
																		comsume event
				Message Q 라는 buffer를 두었기 때문에 해당 서비스에서 문제가 생겨도 해당 서비스에만 문제가 발생한다.
			섞어서 쓸 수도 있다. MQ는 느릴수도 있다.

```