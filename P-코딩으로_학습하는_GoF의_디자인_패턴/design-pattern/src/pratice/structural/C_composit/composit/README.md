```text
컴포짓(composite) 패턴
    그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴(Hierarchy, 트리구조)

클라이언트 입장에서는 '전체'나 '부분'이나 모두 동일한 컴포넌트로 인식할 수 있는 계층 구조를 만든다.
    (Part-Whole Hierarchy)



Client - Component - Composite
after
    Component Interface
    - Item - Leaf
    - Bag - Composite
가능한 가장 추상적인 타입을 사용하기 때문에 유연하다.

장점
    복잡한 트리 구조를 편리하게 사용할 수 있다.
    다형성과 재귀를 활용할 수 있다.
    클라이언트 코드를 변경하지 않고 새로운 앨리먼트 타입을 추가할 수 있다.
단점
    트리를 만들어야 하기 때문에 (공통된 인터페이스를 정의해야 하기 때문에)지나치게 일반화 해야하는 경우가 될 수 있다.
    
JAVA
    JFrame, JTextField, JButton .. HTML 을 만들어주는 Javax.swing 에서 Component interface 를 상속받아 사용중이다.
    모두 최종적으로 Component 에서 만난다.
    그래서 JFrame.setVisible(true) 을 통해 모두 보여준다.

```
