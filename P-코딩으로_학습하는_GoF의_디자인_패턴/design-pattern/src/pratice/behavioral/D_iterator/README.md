```text
iterator
    어떤 집합 객체를 순회하는 패턴
    집합 객체 내부 구조를 노출시키지 않고 순회 하는 방법을 제공하는 패턴.
    • 집합 객체를 순회하는 클라이언트 코드를 변경하지 않고 다양한 순회 방법을 제공할 수 있다.
```
<img width="716" alt="Image" src="https://github.com/user-attachments/assets/25754218-d758-48d4-98ca-c7944ebd21d2" />

```text
    board 가 aggregate 에 해당
    
```
```java
    List<Post> posts = board.getPosts();
    Iterator<Post> iterator = posts.iterator();
```
```text
        위에서 List 가 Aggregate interface 가 되고, Iterator 는 iterator interface 가 된다.
        List 의 실제 구현체인 Board 안에 ArrayList 는 Concrete Aggregate 가 된다.

    Iterator<Post> iterator = board.getRecentPostIterator();
        Post 가 List 를 쓰는 지 Map 을 쓰는 지 몰라도 된다.

    장점
        • 집합 객체가 가지고 있는 객체들에 손쉽게 접근할 수 있다.
        • 일관된 인터페이스를 사용해 여러 형태의 집합 구조를 순회할 수 있다.
    단점
        • 클래스가 늘어나고 복잡도가 증가한다.
        
    자바
        • java.util.Enumeration 과 java.util.Iterator
            (Enumeration 는 자바 1.0 부터 있었는데 현재는 Iterator 에 거의 대체되었다.
            iterator 의 void forEachRemaining() 도 사용할 만 하다.)
        • Java StAX (Streaming API for XML)의 Iterator 기반 API
        • XmlEventReader, XmlEventWriter
    스프링
        • CompositeIterator






























```