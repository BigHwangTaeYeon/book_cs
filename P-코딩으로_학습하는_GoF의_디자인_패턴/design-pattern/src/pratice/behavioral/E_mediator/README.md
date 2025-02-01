```text
중재자 (Mediator) 패턴
    여러 객체들이 소통하는 방법을 캡슐화하는 패턴.
    • 여러 컴포넌트간의 결합도를 중재자를 통해 낮출 수 있다.
    
    여러 객체들간의 의사소통하는 방법을 추상화시켜서 여러 객체들간의 의존성을 낮추는 방법
    
```
    <img width="710" alt="Image" src="https://github.com/user-attachments/assets/693f069b-3536-4cd2-9ec0-6d293941a378" />
```text

    FrontDesk 가 중재자 역할, 의존성을 가져도 괜찮다. 의존성을 몰아 넣은 것.
        각 Restaurant 와 Gym 에서 CleaningService 의존성을 낮추고 Guest 는 FrontDesk 만 의존하게 되었다.

    장점
    • 컴포넌트 코드를 변경하지 않고 새로운 중재자를 만들어 사용할 수 있다.
        (예시로 만든 중재자인 FrontDesk 는 interface 가 아닌 class 로 만들었기에 OCP 를 지킬 수 없다.
        concrete mediator 로 만든다면 새로운 중재자를 생성하며 유연하게 구현할 수 있다.)
    • 각각의 컴포넌트 코드를 보다 간결하게 유지할 수 있다.
    단점
    • 중재자 역할을 하는 클래스의 복잡도와 결합도가 증가한다.
    
    자바
    • ExecutorService
    • Executor
    스프링
    • DispatcherServlet
        Handler 찾는 방법에 해당하는 것이 HandlerMapping
        이렇게 찾아 놓은 Handler 를 어떻게 실행할 것인가, 핸들러를 실행하는 방법을 알고 있는 interface 가 HandlerAdapter 이다.
        ViewResolver 는 뷰 객체가 어떤 것인지 찾아주는 역할






















```