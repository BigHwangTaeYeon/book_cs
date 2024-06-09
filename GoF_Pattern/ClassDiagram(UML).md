# ClassDiagram(UML)

- UML
[staruml](https://staruml.io/)
[umlet](https://www.umlet.com/)

- UML은 Unified Modeling Language의 약자로, 통합 모델링 언어입니다.(표준 언어(약속))

- Class Diagram

    UML 다이어그램은 구조 다이어그램과 행위 다이어그램으로 나뉩니다.

    1) 구조 다이어그램 (Structure Diagram) 은 각 요소들의 정적인 면을 보기 위한 다이어그램입니다.
    따라서 시스템의 개념, 관계 등의 측면에서 요소들을 나타냅니다.
    오늘 살펴볼 클래스 다이어그램도 구조 다이어그램에 속합니다.

    2) 행위 다이어그램 (Behavior Diagram) 은 요소들의 동적인 면을 보기 위한 다이어그램입니다.
    시퀀셜한 표현을 위한 다이어그램이라고 설명하기도 합니다.


[참조](https://velog.io/@khyunjiee/UML-Class-Diagram)
### Class Diagram Element


##### Class

![UserClass](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2F9391fc82-d25d-4003-95ab-4139c08f8c64%2Fimage.png)
```java
public class User {
	private int id;
    private String name;
    
    public Todo getTodo() {
    	// 투두리스트를 확인한다.
        return null;
    }
    
    public void write(String text) {
    	// 투두리스트에 글을 적는다.
    }
}
```
클래스의 세부사항은 필드와 메서드의 접근 제한자(Access modifier) , 필드명(메서드명) , 데이터 타입 , 매개변수(parameter) , 리턴 타입 등을 나타낼 수 있다.

    1) 접근 제한자 (Access modifier)
        + : public
        - : private
        # : protected

    2) 속성 (Attribute)
        접근제어자 이름: 타입 = 기본값
        기본값 생략 가능
        - title: String = ""

    3) 기능 (Method)
        접근제어자 이름(파라미터 속성): 리턴값
        void 리턴값은 생략 가능
        + setTitle(String)
        + getTitle(): String

- 클래스 다이어그램은 필드나 메서드를 모두 선언하는 곳이 아니기 때문에 다이어그램을 그리는 목적에 필요한 것만 명시하는 것이 좋습니다.


##### Stereo Type
UML에서 제공하는 기본 요소 외에 추가적인 확장 요소를 나타내는 타입입니다.
길러멧 기호 («») 사이에 적습니다.

![Interface](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2Fa23b4a19-4efc-49b2-9499-0a946e8e976f%2Fimage.png)
```java
public interface Shape {
	public double area;
}

public class Math {
	public static final double PI = 3.14;
    
    public static double cos(double theta) {
    	// Cosine 계산...
        return 0.0
    }
}
```
필드, 메소드 밑의 밑줄은 static(정적) 필드 또는 메소드를 의미합니다.
{readOnly} 는 final 키워드를 사용하는 상수를 의미합니다.

그 외에도 «abstract» , «enumerate» 등을 많이 사용합니다.


##### Abstract Class/Method
추상 클래스란 1개 이상의 메소드가 구현체 없이 명세만 존재하는 클래스를 말합니다.

![Abstract](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2Fdc0f8f21-eff8-441d-851f-4b691a0e619d%2Fimage.png)
```java
public abstract class User {
	public abstract void work();
}
```
추상 클래스의 이름과 메소드를 italic 체로 기울여서 표현하거나, {abstract} 프로퍼티를 사용합니다.
스테레오 타입을 사용해 표기할 수도 있습니다.


### Class Relationship
가장 중요한 것이 클래스 간의 관계라고 볼 수 있습니다.


### 일반화 (Generalization)
부모(슈퍼) 클래스와 자식(서브) 클래스 간의 상속 관계 (Inheritance) 를 나타냅니다.

부모 클래스는 자식 클래스를 일반화한(Generalize) 것이고,
자식 클래스는 부모 클래스를 구체화한(Spectialize) 입니다. (IS-A 관계)

![Generalization](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2F883f285b-5d30-4dcf-b70b-382dea75b828%2Fimage.png)
```java
public class User {
	private int id;
    private String name;
    
    public Todo getTodo() {
    	// 투두리스트를 확인한다.
        return null;
    }
    
    public void write(String text) {
    	// 투두리스트에 글을 적는다.
    }
}
public class Student extends User {
	public void study() {
    	// 공부한다.
    }
}
public class Teacher extends User {
	public void teach() {
    	// 가르친다.
    }
}
```
위와 같이 표기법은 클래스 사이에 실선을 연결하고 부모 클래스 쪽에 비어 있는 삼각형 화살표를 그립니다.


### 실체화 (Realization)
interface 의 기능을 실제 기능으로 구현하는 것을 의미합니다.

![Realization](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2Fecb6b031-a2ce-47b2-8c3a-742191ff0b58%2Fimage.png)
```java
public interface Shape {
	public double area;
    
    public abstract double calcArea();
}
public class Circle implements Shape {
	@Override
	public double calcArea() {
    	// 면적 계산
        return area;
    }
}
```
인터페이스와 클래스 사이의 Relize 관계는 점선과 인터페이스 쪽에 비어있는 삼각형 화살표로 연결합니다.



### 의존 (Dependency)
어떤 클래스가 다른 클래스를 참조하는 것을 의미합니다.

![Dependency](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2F3c5cbe3a-7e8d-492b-a45e-f78c288c1397%2Fimage.png)
```java
public class User {
	public Todo createTodo() {
    	// 객체 생성 및 리턴
    	return new Todo();
    }
    
    public void writeTodo(Todo todo) {
    	// 객체를 매개변수로 받아 사용
        Todo todo = todo.getTodo();
    }
}
```
클래스 사이를 점선과 참조할 클래스에 화살표를 선으로 그려 표현합니다.

참조의 형태는 아래와 같습니다.
    - 메서드 내 대상 클래스 객체 생성
    - 메서드 내 대상 클래스 객체 사용
    - 메서드 내 대상 클래스 메서드 호출
    - 메서드 내 대상 클래스 객체 리턴
    - 메서드에서 대상 클래스 객체를 매개변수로 받는 것

이와 같은 객체 참조는 계속 유지하지 않고 메서드의 호출이 끝나면 의존 관계의 클래스와 관계가 끝납니다.


### 연관 (Association, Directed Association)
클래스 다이어그램에서의 Association은 보통 다른 객체의 참조를 가지는 필드를 의미합니다.

![Association, Directed Association](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2F84c48ebf-fd22-477a-9735-be31357d0cc8%2Fimage.png)
```java
public class User {
	private List<Phone> phones;
}
```
위의 다이어그램은 두 가지 형태의 Association 을 나타내고 있습니다.

일반적인 Association
    - 실선 하나로 클래스를 연결합니다.
    - 방향이 없으므로 User가 Phone을 참조할 수도, Phone 이 User 를 참조할 수도, 둘 다일 수도 있습니다.

Directed Association
    클래스를 실선으로 연결 후 끝에 화살표를 추가합니다.
    User 에서 Phone 으로 화살표가 향하고 있으므로 User 가 Phone 을 참조하는 것을 의미합니다.
    화살표 옆의 -phones 는 roleName(역할명)을 나타내고 어떤 역할로 참조되는지를 의미합니다.

두 형태의 Association 간의 차이는 방향성입니다.
방향의 유무에 따라 참조하는 쪽과 참조 당하는 쪽을 구분합니다.
(*) 은 개수를 나타내는데 대상 클래스에 가질 수 있는 인스턴스 개수 범위를 뜻합니다.
    1 : 1개
    * : 0~n개
n...m : n부터 m까지 연관관계를 맺음


### 집합 (Aggregation, Shared Aggregation)
Association 관계를 조금 더 특수하게 나타내 전체(whole)와 부분(part)의 관계를 나타냅니다.
Aggregation은 Association의 집합 관계를 나타내는 것으로 Collection 이나 Array 를 이용하는 관계입니다.
이 관계는 일반적인 Association으로도 나타낼 수 있어 논란이 지속되고 있습니다.

### 합성 (Composition, Composite Aggregation)
Aggregation과 비슷하게 전체(whole)와 부분(part)의 집합 관계를 나타내지만,
- 개념적으로 Aggregation 보다 강한 집합을 의미합니다.

![Composition, Composite Aggregation](https://velog.velcdn.com/images%2Fkhyunjiee%2Fpost%2F701164b0-4c2f-48c9-8ab7-a09a97d8f510%2Fimage.png)

Composition vs Aggregation
    - Composition은 Aggregation보다 강한 집합입니다.
    - Composition은 part가 whole의 소유입니다.
    - Aggregation은 part가 whole에 독립적이어서 whole이 part를 빌려쓰는 것과 비슷합니다.

Aggregation과 명확하게 다르게 나타나는 부분들
    1) part를 가지는 whole 인스턴스가 part 인스턴스의 전체 수명을 책임집니다.
        whole 인스턴스가 part 인스턴스를 생성
        whole 인스턴스가 소멸하면 part 인스턴스도 함께 소멸
        whole 인스턴스가 복사되면 part 인스턴스도 함께 복사
    2) part에 해당하는 인스턴스는 공유될 수 없습니다.

Aggregation과 Composition을 UML 툴에서 그린 후 코드를 만들면 똑같은 코드가 생성됩니다.
하지만 Composition에서는 개발자가 구현해야 할 부분이 몇 가지 있습니다.
    - part 인스턴스의 공유 방지를 위한 Deep Copy 를 구현합니다.
    - whole 인스턴스가 part 인스턴스의 수명을 책임져야 하므로 whole 클래스의 생성자 또는 기타 메소드 내에서 part 인스턴스를 생성합니다.
    - 외부에서 part 객체를 생성하지 못하도록 whole 클래스에는 part 인스턴스에 대한 setter를 삭제합니다.
    - 자바는 Garbage Collector 가 객체 소멸을 담당하므로 part 인스턴스의 소멸은 신경쓰지 않아도 됩니다.