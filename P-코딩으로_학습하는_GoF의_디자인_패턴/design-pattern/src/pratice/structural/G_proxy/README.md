```text
Proxy
    접근제어, 
    해당 인스턴스를 생성하기 위해 많은 리소스를 사용해야한다면,
        미리 만들어 두거나,
        쓰이지 않으면 최초에 쓰일때 초기화를 지원하는 방법.
    로깅
    캐싱
    
    target 을 거치지 않고 proxy 에서 처리.

    특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴
    - 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용해 사용 할 수 있다.
    
    Client 는 proxy 를 사용
    
    GameService - RealSubject

```
```java

public class GameServiceProxy implements GameService{
    private GameService gameService;

    @Override
    public void startGame() {
        if(this.gameService == null) {  // Lazy initialization 초기화 지연
            this.gameService = new DefaultGameService();
        }

        long start = System.currentTimeMillis();
        gameService.startGame();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
```
```text

장점
    기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다. OCP, SRP
    기존 코드가 해야 하는 일만 유지할 수 있다.
    기능 추가 및 초기화 지연(잘 사용하지 않는데 메모리를 많이 사용해야하거나, 인스턴스 생성에 많은 자원이 필요하여 나중에 생산하기 위해서 등등) 등으로 다양하게 활용할 수 있다.
단점
    코드 복잡도가 증가한다.

JAVA
    이러한 프록시 인스턴스를 런타임에 만들수 있게 제공, Dynamic proxy (런타임 관련은 Dynamic 이란 표현을 사용)
    앱 실행 중, 인스턴스를 동적으로 만들수 있는 방법, 자바의 리플랙션 기능 중에 제공
    
Spring
    자바에서 사용된 리플랙션 같은 기능을 AOP 로 제공한다.
        여러 코드에 흩어질 수 있는 코드를 한곳에 Aspect 라는 개념으로 모아주는 기능
        스프링이 관리하는 빈에만 적용 가능
```
```java
    @Around("bean(gameService)")
    public void timestamp(ProceedingJoinPoint point) throws Throwable {
    // point 는 gameService 에 있는 method 를 가르키게 된다.
    //...
    }
```
```text
    @Chacheable
    @Transactional
    ... 등등등
```
