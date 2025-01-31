```text
command pattern
    - 요청을 캡슐화하여 호출자(invoker)와 수신자(receiver)를 분리하는 패턴
    - 요청을 처리하는 방법이 바뀌더라도, 호출자의 코드는 변경되지 않는다.
    요청을 호출하는 쪽과 처리하는 쪽을 디커플링 하는 패턴
    중간에 command 라는 type 을 추가하여 분리
    
    invoke 와 receiver 간의 관계가 타이트하기에 하나를 고치면 모두 고쳐야한다.
    
    디자인 패턴에서 행동 패턴이란 책임을 분산해서 구조를 개선하는, 의존성을 좀 더 디커플링하는 의도가 많다.

```
```java
    public interface Command {
        void execute();
    }
```
```text
    위와 같은 Command Interface 를 만들지 않아도 된다.
    (return 은 없고, 실행하는 method 딱 하나만 있는 위와 같은 형태)
    
    Java 에는 Runnable 이라는 interface 가 있다.
    (쓰레드 공부할 때 많이 보인다.)
```
```java
    @FunctionalInterface
    public interface Runnable {
        public abstract void run();
    }
```
```text
    public abstract 는 interface 에는 default 로 적용되는 부분이기에 있어도 없어도 된다.
    
    Runnable interface 를 사용해도 상관없지만, 해당 앱과 특화되어있는 이름을 부여해주기 위해 만들었다.

```
```java
public class Button {
    private Light light;

    public Button(Light light) {
        this.light = light;
    }

    public void press() {
        light.on();
    }

    public static void main(String[] args) {
        Button button = new Button(new Light());
        button.press();
    }
}
public class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public static void main(String[] args) {
        Button button = new Button(new LightOnCommand(new Light()));
        button.press();
    }
}
```
```text
    기존에는 receiver(new Light())가 바뀌면 모든 invoke(private Light light;, public Button(..){..}, press(){..})가 바뀐다.
    (Light 가 아닌 다른 것으로 변경이 된다면)
    변경 후에는 Command(new LightOnCommand(new Light())) 만 바뀐다.
        변화되는 범위가 축소된다.

장점
    기존 코드를 변경하지 않고 새로운 커맨드를 만들 수 있다. 각각의 자기 할 일만 한다.(SRP)
    수신자의 코드가 변경되어도 호출자의 코드는 변경되지 않는다.
    커맨드 객체를 로깅, DB에 저장, 네트워크로 전송 하는 등 다양한 방법으로 활용할 수 있다.
단점
    코드가 복잡해지고 클래스가 많아진다.

Java
```
```java
    Light light = new Light();
    // 4 개의 쓰레드를 가지는 쓰레드 풀을 만들어준다.
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    // ExecutorService 가 쓰레드 풀을 활용해서 비동기적으로 Operation 을 실행할 수 있는 기능을 제공한다.
    // Runnable 의 익명 함수를 사용하여 실행, Command pattern
    executorService.submit(()->light.on()); // 람다식
    executorService.submit(light::on);  // method reference
    executorService.submit(light::off);
    executorService.submit(light::on);
    executorService.submit(light::off);
    executorService.shutdown();
```
```text
Spring
    SimpleJdbcInsert (JdbcTemplate 이 외에 사용하는 클래스)
        일종의 하나의 Command
        insert query 를 실행하기 위한 모든 정보를 가지고 있는 하나의 command Object
```
