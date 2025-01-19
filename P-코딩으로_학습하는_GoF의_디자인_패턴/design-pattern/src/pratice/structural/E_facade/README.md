```text
Facade pattern
    복잡한 서브 시스템 의존성을 최소화하는 방법.
    클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화할 수 있다.

Javax.mail 에서 지원하는 이메일 발송 라이브러리의 의존성을
    EmailSettings, EmailSender, EmailMessage Class 를 만들어 사용함으로 써,
    해당 라이브러리를 의존(import)하지 않게 되어있다.
    퍼사드 클래스의 의존은 어쩔수가 없고
    유연해진다는 것은 테스트 상황에서 Mockup 이 간편하다.
        기존은 Mocking 하기 힘들다.
    다른 곳에서도 사용한다면 기존에는 모든 것을 나열해야 했지만 한 곳에 모아두었다는 의미가 있고
    Interface, 다른 기술 라이브러리를 사용하면 그쪽 부분만 수정하면 된다.
    
장점
    서브 시스템에 대한 의존성을 한 곳으로 모을 수 있다.
    
단점
    퍼사드 클래스가 서브 시스템에 대한 모든 의존성을 가진다.
    - 결국 모든 의존성을 피할 수 없다. 사용해야할까? 똑같은 것이 아닐까?
    - 가독성, 관심사 분리

자바는 찾기 힘듦
스프링
    
```

```java
    MailSender mailSender = new JavaMailSenderImpl();
    PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();
```
```text

    Client 는 MailSender를 사용하고,
    실제 코드는 JavaMailSenderImpl 에 숨어있다.

    MailSender, PlatformTransactionManager 모두 특정 기술에 종속적이지 않다.
```
