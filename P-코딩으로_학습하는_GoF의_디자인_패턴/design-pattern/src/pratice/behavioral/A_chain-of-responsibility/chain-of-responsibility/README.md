```text
행동, 동작과 관련된 디자인 패턴
Chain Of Responsibility(각 책임들이 연결)
    책임 - 단일 책임 원칙의 책임을 의미
    
    - 요청을 보내는 쪽(sender)과 처리하는 쪽(receiver)을 분리하는 패턴
    - 보내는 쪽에서 요청을 처리하는 핸들러가 어떠한 구체적인 타입인지 상관없이 디커플링 된 상태에서 요청을 처리할 수 있게 해주는 패턴

    만약 인증, 인가를 해야한다면
    요청을 처리하는 쪽에서 받아서 인증을 처리해야한다.
    인증된 사용자가 보낸 것인가, 핸들러를 사용할 수 있는 사용자가 보낸 것인지 확인이 필요할 때.
        - Handler 에 모든 기능을 넣으면 단일 책임 원칙에 위배가 된다.
        - 만약 AuthRequestHandler 를 만들고 RequestHandler 를 상속받아 인증 인가 코드를 넣고 super.handler() 를 호출하면
            SRP 는 지킬 수 있지만 클라이언트 코드가 바뀐다.
        - 또 로깅을 추가해야한다면 Auth.. 처럼 하면 어떻게 SRP 를 지키며 추가시키지 ? (그래서 chain 이 필요)
            또한 클라이언트가 모든 것을 직접 알아야 한다.
    

결과
    각 핸들러에 조건을 넣어 처리하지 않아도 될 부분을 거를 수도 있고 추가 동작을 넣을 수 있다.
    중요한건 클라이언트가 어떤 핸들러를 쓸지 결정하지 않는다는 것이다.
    구체적인 핸들러 타입으로부터 요청을 처리하는 쪽과 요청을 보내는 쪽의 디커플링되어있다.

추가
```
```java
new AuthRequestHandler(new LogginRequestHandler(new PrintRequestHandler(null)));
```
```text
    이러한 부분을 빌드 패턴으로 정리할 수도 있다.
    다른 체인을 갔다 온 다음 처리하는 방법도 있다.
    
    
장점
    클라이언트 코드를 변경하지 않고 얼마든지 체인을 추가할 수 있다. OCP
    각 핸들러는 본인의 기능만을 사용한다. SRP

단점
    디버깅이 번거롭다.
    
java
    Servlet 의 Filer, Interceptor 에서 볼 수 있다.
    여러개의 filter 를 거치면서 servlet 에 도달한다.
```
```java
@Override
public void doFilter(...) {
    // todo 전처리
    // 다음 체인으로 넘기려면 아래 함수를 호출해야한다.
    chain.doFilter(...);
    // todo 후처리
}
```
```text
    필터에서 걸러내야한다면 chain.doFilter() 를 사용하지 않아도 된다.
    필터 등록방법
        App class 에 @ServletComponentScan 등록
        custom Filter class 에 @WebFilter 등록
            * 패키지를 보면 알겠지만 javax.servlet... spring 에서 제공하는 것이 아니라 servlet 에서 제공하는 것이다.
            * 이것을 스캔에서 빈으로 등록해주는 역할이 @ServletComponentScan 의 spring boot 기능이다.
            * url pattern 을 정할 수 있고 해당 mapping 주소에 접근했을 때 활성화
```
