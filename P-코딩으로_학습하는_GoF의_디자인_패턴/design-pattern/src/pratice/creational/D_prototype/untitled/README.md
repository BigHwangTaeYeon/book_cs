```text

프로토타입(prototype) 패턴
    기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법
    복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다.
    
    자바가 인스턴스를 복제해주는 기본적인 메커니즘을 제공하기에 
    자바가 제공하는 기능을 그대로 사용할 예정.
    커스텀하는 방법도 알게될 것.

    DB 를 통하거나 I/O 작업을 통해 객체를 생성해야 한다면
    프로토타입 패턴을 통해 복제하여 사용하는 것이 장점이 많다.

Java 의 Object class 의 clone() 는 shallow copy(얕은 복사) 를 지원한다.
    Cloneable interface 를 상속받아 사용하면 된다.
    deep copy 를 지원하지 않는다.
```
```java

    GithubRepository repository = new GithubRepository();
    GithubIssue githubIssue = new GithubIssue(repository);
    GithubIssue clone = (GithubIssue) githubIssue.clone();
```
```text
    위 코드와 같이 githubIssue 가 가지고 있는 GithubRepository 와 clone 이 가지고 있는 GithubRepository 는
    System.out.println("clone.get = " + (clone.getRepository() == githubIssue.getRepository()));
        - true
    같은 인스턴스를 가진다
    이것이 얕은 복사이다.

    deep copy 로 사용하고 싶으면, clone() 를 수정하면 된다.

장점
    복잡한 객체 생성 과정을 숨길 수 있다.
    복잡한 과정의 인스턴스를 만드는 것보다 비용(시간 또는 메모리)이 효율적일 수 있다.
    추상적인 타입을 리턴할 수 있다.

단점
    복잡한 객체를 만드는 과정 자체가 복잡할 수 있다.(특히, 순환참조가 있는 경우)

실무
    ArrayList 에서 제공하는 clone() 이 있지만 잘 사용하지 않는다.
    보통 객체 타입으로 interface 인 List 로 받아 사용하기 때문이다.
        - 그래야 더 유연하게 사용이 가능하다.
    List 는 clone 이 없다.
    
    대신 List<Student> clone = new ArrayList<>(Student)
    이와 같이 사용한다.
    
    





























```
