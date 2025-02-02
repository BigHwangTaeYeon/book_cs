```text
템플릿 메소드 (Template method) 패턴
    알고리듬 구조(파일에서 데이터를 읽어오고 처리하고 출력하는 것들)를 서브 클래스가 확장할 수 있도록 템플릿으로 제공하는 방법.
    • 추상 클래스는 템플릿을 제공하고 하위 클래스는 구체적인 알고리듬을 제공한다.
    
    abstract 를 사용한다는 것이 핵심인듯
    공통되는 부분을 제외하고 각 기능에 따라 바뀌는 몇줄을 option command m 으로 intellij 에서 제공하는 extract method 추출하여 상속받고 구현해준다.
    그리고 클라이언트는 해당 기능을 인스턴스로 주입하여 사용.
    
```
<img width="258" alt="Image" src="https://github.com/user-attachments/assets/408ae6dd-1b5c-4693-8b5b-7d8f0acd9f3a" />

```text

템플릿 콜백 (Template-Callback) 패턴
    콜백으로 상속 대신 위임을 사용하는 템플릿 패턴.
    • 상속 대신 익명 내부 클래스 또는 람다 표현식을 활용할 수 있다.

    기존의 추상 클래스와 추상 메서드가 존재할 필요 없다.
    사용할 method 에 파라미터로 Operation interface 를 전달하기만 하면 된다.
        전달하는 방식은 익명 내부 클래스로 구현해주거나, 람다식으로 전달해주면 된다.
        상속이 아닌 위임으로 하기 때문에 유연하게 코드 작성이 가능하고
        클래스가 추가로 발생하지 않는다.
        물론 클래스를 따로 만들어서 사용해도 된다.

    템플릿 콜백 패턴은 GoF 가 정의한 패턴은 아니다.
    
```
<img width="820" alt="Image" src="https://github.com/user-attachments/assets/0ef5ca9d-46b7-43d2-8a96-e7255c80b5c3" />

```text

템플릿 메소드 (Template method) 패턴
    장점
    • 템플릿 코드를 재사용하고 중복 코드를 줄일 수 있다.
    • 템플릿 코드를 변경하지 않고 상속을 받아서 구체적인 알고리듬만 변경할 수 있다.
    단점
    • 리스코프 치환 원칙을 위반할 수도 있다.
        상속 구조에서 자식 클래스가 부모가 Operation 하는 의도를 맞추어 해야한다.
    • 알고리듬 구조가 복잡할 수록 템플릿을 유지하기 어려워진다.

    자바
    • HttpServlet
    스프링
    • 템플릿 메소드 패턴
    • Configuration
    • 템플릿 콜백 패턴
    • JdbcTemplate
    • RestTemplate
```