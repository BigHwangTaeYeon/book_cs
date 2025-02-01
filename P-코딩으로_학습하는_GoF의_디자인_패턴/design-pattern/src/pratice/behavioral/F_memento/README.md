```text
메멘토 (Memento) 패턴
    캡슐화를 유지하면서 객체 내부 상태를 외부에 저장하는 방법.
    • 객체 상태를 외부에 저장했다가 해당 상태로 다시 복구할 수 있다.
    
    캡슐화를 유지한 상태에서(encapsulation), 객체 내부의 상태를 밖으로 상세하게 공개하지 않으면서 저장하고 복원하는 방법(undo)
    
    기존 코드는 클라이언트가 객체의 내부 상태를 알아야 했지만 Memento 를 적용하여 결합도를 낮춘다.

```
    <img width="744" alt="Image" src="https://github.com/user-attachments/assets/88bf6296-92be-46c1-8715-17ab0ac226fb" />
```text
    
    Game class 가 Originator 에 해당한다.
    본래의 상태를 저장하고 복원한다.
    
    Originator 정보를 CareTaker 가 가져와서 저장하고 있고
    가진 정보로 복원을 할 수 있는 외부 클래스이다.
    
    이 외부정보(CareTaker)를 통해 memento 라는 객체로 추상화한다.
    그래서 Originator 는 Memento 타입을 가지고 있다.
    immutable 한 객체로 한번 저장된 정보는 변하지 않는다. 

    Vo 와 Dto 관계같당

    장점
    • 캡슐화를 지키면서 상태 객체 상태 스냅샷을 만들 수 있다.
    • 객체 상태 저장하고 또는 복원하는 역할을 CareTaker에게 위임할 수 있다.
    • 객체 상태가 바뀌어도 클라이언트 코드는 변경되지 않는다.
    단점
    • 많은 정보를 저장하는 Mementor를 자주 생성하는 경우 메모리 사용량에 많은 영향을 줄 수 있다.
    
    자바
    • 객체 직렬화, java.io.Serializable
    • java.util.Date (긴가민가 하다 하심)

```