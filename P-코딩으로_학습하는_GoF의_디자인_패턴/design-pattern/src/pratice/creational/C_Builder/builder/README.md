```text

Builder pattern
    인스턴스 생성 관련
    인스턴스가 동일한 프로세스를 통해서 다양한 구성으로 만들어 준다.

    다양한 파라미터를 지원하는 생성자를 만들고 싶을 때,
    너무 매개변수가 장황해지고 생성자가 너무 많아진다.
    
    도메인에 개념에 맞춰 데이터를 넣을 수 있다.
    실수를 줄여준다.
    
    동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법.
    (복잡한) 객체를 만드는 프로세스를 독립적으로 분리할 수 있다.
    
    Director 를 사용하면 반복되는 빌더 호출 스택을 빌더에 숨겨서
    클라이언트는 간단하게 인스턴스를 받아 사용할 수 있다.

장점
    만들기 복잡한 객체를 순차적으로 만들 수 있는 장점이 있다.
    객체 생성에 순서가 있다면 프로세스별로 첫번째 빌더를 생성하고 두번째 빌더에서 제공하는 메서드를 사용하게 끔 할 수 있다.
    검증도 가능하다.
    복잡한 로직을 숨길 수 있다.
    불안정한 객체를 만들지 않도록 안전장치를 설치할 수 있다.

단점
    클라이언트에서 만들 때 반드시 디렉터 또는 빌더까지 만들어야 다음 스텝을 거쳐야 한다는 단점이 있다. 너무 인스턴스를 많이 만든다.
    구조가 기존에 형태보다 복잡해진다.

실무
    JAVA 에서 사용
        StringBuilder, StringBuffer
        String result = new StringBuilder().append("gogo").append("gogo").toString();
    
        lombok @Builder
    
    Spring 에서 사용
```
```java
UriComponents java = UriComponentsBuilder.newInstence()
        .scheme("http")
        .host()
        .path()
        .build()
        .encode();
```
```text






















```

