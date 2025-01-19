```text
Flyweight pattern
    Fly 가벼운
    자주 변하는 속성과 자주 변하지 않는 속성을 분리, 공통되는 부분을 모아서 재사용 
    객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
    
    자주 변하는 속성(또는 외적인 속성, extrinsit)과 변하지 않는 속성(또는 내적인 속성, intrinsit)을 분리하고
    재사용하여 메모리 사용을 줄일 수 있다.
    
장점
    애플리케이션에서 사용되는 메모리를 줄일 수 있다.
단점
    코드의 복잡도가 증가한다.

도메인과 관련되서 사용되는 부분을 간추리거나 줄이는 방법이기에 자바나 스프링에서 찾아보기 쉽지 않다.

Integer
    Cache to support the object identity semantics of autoboxing for values between
         * -128 and 127 (inclusive) as required by JLS.
    그래서 -128 ~ 127 사이에 있는 값들은 같은 인스턴스를 사용한다.
    그리고 자주사용되는 값들은 캐싱을 한다.
    중요한 것은 Integer == Integer 은 사용하면 안된다.
    equals() 를 사용할 것.

```
