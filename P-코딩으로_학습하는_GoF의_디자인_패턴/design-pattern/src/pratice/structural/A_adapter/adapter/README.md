```text

어댑터(adapter) 패턴
    기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
    클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다.

    client - LoginHandler
    target interface - UserDetailsService, UserDetails
    adapter - AccountUserDetailsService, AccountUserDetails

장점
    기존 코드를 변경하지 않고 원하는 인터페이스 구현체를 만들어 재사용할 수 있다. (OCP 객체지향)
    기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리할 수 있다. (SRP 객체지향)
단점
    새 클래스가 생겨 복잡도가 증가할 수 있다.
    경우에 따라서는 기존 코드가 해당 인터페이스를 구현하도록 수정하는 것이 좋은 선택일 수 있다.
        (Account 에서 UserDetails 를 직접 구현)
실무
```
```java
    // 예1.
    // T... a 가변 인자 "a", "b", "c" 배열
    // 배열을 리스트로 변환해서 반환
    List<String> list = Arrays.asList("a", "b", "c");
    /**
     * list 가 adaptee
     * Collections.enumeration() 가 adapter
     * Enumeration<String> 가 target interface
     */
    Enumeration<String> enumeration = Collections.enumeration(list);
            System.out.println("enumeration = " + enumeration);
    ArrayList<String> list1 = Collections.list(enumeration);
    // 예2.
    try(InputStream is = new FileInputStream("README.md");
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader reader = new BufferedReader(isr))
```
```text
    세 타입 모두 어댑터 패턴을 사용했다.
    자세히 들어가면 다른 패턴을 사용했을 수 있지만
    new FileInputStream() 어댑터를 통해 문자열을 넣고 원하는 target 인 InputStream 을 반환한다.
    마찬가지로 new InputStreamReader(is);, new BufferedReader(isr) 각각 InputStream, InputStreamReader 인자로 넣어주고
    원하는 target 을 생성한다.

    Spring 에서는 지원하는 MVC 에서 HandlerAdapter 가 있다.
    우리가 작성하는 다양한 형태의 핸들러 코드를 스프링 MVC 가 실행할 수 있는 형태로 변환해주는 어댑터용 인터페이스
```
