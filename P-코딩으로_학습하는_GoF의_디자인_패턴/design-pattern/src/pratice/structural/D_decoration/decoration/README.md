
```text

데코레이션 패턴
    런타임에 기존 코드를 확장하는 방법
    기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴

고정적인, 스태틱하게, 컴파일 타임
다이나믹하게 동적으로 유연하게 이런표현은 런타임에 변경이 가능하다는 표현

    CommentService interface 를 상속받아
    일반적으로는 DefaultCommentService 사용하고,
    CommentService 를 상속받은 CommentDecorate 를 다리 역할로 두고
        TrimmingCommentDecorate 또는 SpamFilteringDecorate 에 기존에 생성한 인터페이스인 DefaultCommentService 를 상속받아서
        상황에 따라 유연하게 추가 기능(Trim, SpamFilter)을 사용할 수 있게 되었다.
    
    중요한 차이점은 TrimmingCommentDecorate 또는 SpamFilteringDecorate 가 상속받을 때,
        새로운 인스턴스가 아닌 부모가 주입받은 인스턴스를 그대로 상속받기 때문에 추가적으로 두 기능 모두 활성화를 해야할 때,
        "기존 코드에 추가적인 코드 없이 사용이 가능"하다. - OCP
    
    interface CommentService - DIP
    
장점
    새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다. SRP
    컴파일 타임이 아닌 런타임에 동적으로 기능을 변경할 수 있다.
단점
    데코레이터를 조합하는 코드가 복잡할 수 있다.

JAVA
```

```java
import java.util.ArrayList;
import java.util.Collections;
// Collections 가 제공하는 데코레이트 메서드
ArrayList list = new ArrayList();
list.add(new Book());
// checked.. method 는 타입을 확인해주는 메소드이다.
// 그래서 Book.class 를 제외하고는 books 에 데이터를 넣을 수 없다.
List books = Collections.checkedList(lsit, Book.class);
// list 에는 Item 을 넣을 수 있지만
list.add(new Item());
// books 에는 checkedList 로 인해서 Item을 넣을 수 없다.
// 결국 type casting 에러가 나오게 된다.
books.add(new Item());

// 아래와 같이 synchronized... 에서도 
// 어떤 Collection operation 들이 동시에 처리하지 않고 순차적으로 처리하게 만들어주는
// 컬렉션 변환용 메소드이다.
Collections.synchronized...
// 객체를 불변으로 만들어준다.
Collections.unmodifable...
// 위와 같이 메소드를 호출하고 add() 하려해도 추가할 수 없다.

// 이러한 기능을 wrapper(decorator)를 통해 사용 가능하다.

private static class Book{}
private static class Item{}
```
```text
Spring
    - 빈 설정 데코레이터 (거의 사용할 일이 없다.)
    BeanDefinitionDecorator
    - 웹플럭스 HTTP 요청/응답 데코레이터 (조금은 사용할 수도 있다.)
    ServletHttpRequestDecorator
    ServletHttpResponseDecorator
```

