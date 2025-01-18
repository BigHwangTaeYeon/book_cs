```text

브릿지(Bridge) 패턴
    추상적인 것과 구체적인 것을 분리하여 연결하는 패턴

하나의 계층 구조일 때 보다 각기 나누었을 때 독립적인 계층 구조로 발전 시킬 수 있다.
Before 에서는 챔피언 interface 에 KDA... PoolParty... 등 스킨 클래스를 만들었지만
    해당 챔피언의 스킬 기능을 추가한다면 클래스는 굉장히 많이 늘어날 것이다.
    이것을 브릿지 패턴으로 해결이 가능하다.

Client -> Abstraction -> Interface
            operation       method

장점
    추상적인 코드를 구체적인 코드 변경 없이도 독립적으로 확장할 수 있다. OCP
    추상적인 코드와 구체적인 코드를 변경할 수 있다. SRP
        - OCP, SRP => 재사용, 중복 제거
단점
    계층 구조가 늘어나 복잡도가 증가할 수 있다.

JAVA
    JDBC
        Connection DriverManager 의 코드가 바뀌지 않아도 새로운 데이터베이스에 연결이 가능하다.
    Logger, logging facade(log4j) - Logger 또는 LoggerFactory 를 변경하지 않아도 사용 가능
SPRING
    PSA
        MailSender, PlatformTransactionManager 추상 코드
        JavaMailSenderImpl, JdbcTransactionManager Impl 코드
        가 변경되지 않아도 사용가능
```
