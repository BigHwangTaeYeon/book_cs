```text
옵저버 (Observer) 패턴
    다수의 객체가 특정 객체 상태 변화를 감지하고 알림을 받는 패턴.
    • 발행(publish)-구독(subscribe) 패턴을 구현할 수 있다.
    
    여러개의 객체들이 보통 어떤 특정한 하나의 상태변화를 감지하고 반응을 해야할 때 사용
    이 패턴을 적용하면, pub(publisher) sub(subscript)을 쉽게 구현할 수 있다.

    주기적으로 가져오는 Polling Mechanism 으로는 해당 어플리케이션과는 잘 맞지 않는 다는 판단.
    그렇게 옵저버 디자인 패턴을 적용
    
```
<img width="762" alt="Image" src="https://github.com/user-attachments/assets/306c1e32-2232-4d83-ad6a-bd7bc9145ba1" />

```text

    Subject 의 기능은 여러 옵저버들을 등록하거나 해제할 수 있는 기능
    
    장점
    • 상태를 변경하는 객체(publisher)와 변경을 감지하는 객체(subsriber)의 관계를 느슨하게 유지할 수 있다.
    • Subject의 상태 변경을 주기적으로 조회하지 않고 자동으로 감지할 수 있다.
    • 런타임에 옵저버를 추가하거나 제거할 수 있다.
    - Map<String, List<Subscriber>> subscribers = new HashMap<>();
        garbage collection 의 대상이 아니다.
        안쓰더라도 Map 에 인스턴스가 있기 때문에.
        주의할 점은 메모리가 계속 쌓여서 out of memory 가 발생할 수도 있다.
            적절한 순간에 unregister 가 필요하다.
    단점
    • 복잡도가 증가한다.
    • 다수의 Observer 객체를 등록 이후 해지 않는다면 memory leak이 발생할 수도 있다.

    자바
    • Observable과 Observer (자바 9부터 deprecated)
    • 자바 9 이후 부터는
    • PropertyChangeListener, PropertyChangeEvent
    • Flow API
    • SAX (Simple API for XML) 라이브러리
    스프링
    • ApplicationContext와 ApplicationEvent
        event publisher 이다.
    
    spring 을 띄웠을 때 자동으로 실행하게 하려면 @Component 로 Bean 등록해주고 ApplicationRunner 를 상속받아 run 을 구현해주면 된다.






































```