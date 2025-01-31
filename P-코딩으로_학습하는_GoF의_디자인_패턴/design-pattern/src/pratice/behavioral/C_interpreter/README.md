```text
interpreter
    보통 사람이 작성한 코드를 기계가 이해하기 쉬운 형태로 변환해주는 장치를 interpreter, compiler 라고 한다.
    단어로는 통역하는 사람들, 연주자들.. 이라 뜻한다.
    결국 원본이 되는 무언가를 다른 형태로 바꾸어주는 의미이다.
    
    자주 해결해야하는 문제들을 일종의 패턴, 언어, 문법 등으로 정의하고
    그 문법에 맞춰서 표현식, 어떤 문자를 작성하면 대입해서 문제를 푸는 것이다.
    ex. 정규표현식
    
    PostfixNotation postfixNotation = new PostfixNotation("123+-");
    위와 같이 123+- 와 같은 형식을 많이 사용한다면, (숫자와 부호는 다른 것으로 바뀌어도 상관없다)
    인터프리터 패턴을 고려해볼 수 있다.

    "자주 등장하는 문제를 간단한 언어로 정의하고 재사용하는 패턴"
    - 반복되는 문제 패턴을 언어 또는 문법으로 정의하고 확장할 수 있다.
    
    Expression interface, TerminalExpression, NonTerminalExpression
    
    Composite 패턴과 유사하다.(tree 구조)

    정의 : 요청을 캡슐화 하여 호출자(invoke)와 수신자(receiver)를 분리하는 패턴
    
    PostfixParser 은 표현식(xyz+-)을 통해 인스턴스만 만들어 MEM 에 올려놓고
    PostfixExpression interface 의 interpret(...)를 통해 메모리에 올려둔 인스턴스의 구현체가 작업을 시작된다.
    
장점
    자주 등장하는 문제 패턴을 언어와 문법으로 정의할 수 있다.
    기존 코드를 변경하지 않고 새로운 Expression 을 추가할 수 있다. OCP
    각각의 Expression 들이 제 할일을 하고 있다. SRP
단점
    복잡한 문법을 표현하려면 Expression 과 Parser 가 복잡해진다.

Java
    Compiler, 정규표현식 에 적용
    Pattern.matches("[a-z]{6}", "spring")
Spring
    ExpressionParser, Expression

```
