```text
팩토리 메서드 패턴
구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 결정한다.

다양한 구현체(Product)가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.

확장에 열려있고 변경에 닫혀있는 구조라면
새로운 만드는 배를 위해서 기존 코드가 변경이 되면 안된다.
즉, Ship, ShipFactory, WhiteShip, WhiteShipFactory 가 변경되면 안된다.

클라이언트 코드는 변경이 되어있다.
그러면 이것이 변경에 닫혀있는 것이 맞는 건가에 대한 의문.
그래서 의존성 주입, 인터페이스 기반으로 코딩하는 코드를 작성하고 구체적인 클래스들의 의존성을 주입하는 방법을 사용하면
클라이언트 코드도 변경되지 않도록 고칠 수 있다.

1. 팩토리 메서드 패턴의 적용했을 때의 장단점 ?
    - 장점
    OCP 원칙을 지키며 기존 코드를 바꾸지 않고, 인스턴스를 만드는 과정을 바꾸지 않고 새로운 인스턴스를 다른 방법으로 확장 가능합니다.
    Product 와 Creator(Instance) 간의 Coupling 을 느슨하게 가져갔기 때문입니다. (느슨한 결합)
    그렇기에 기존 코드를 건드리지 않고 확장할 수 있기에 코드는 훨씬 더 간결해지고 기존 코드가 복잡해지지 않습니다.
    - 단점
   패턴을 적용하기 전에는 적은 수의 클래스만으로도 생산이 가능했습니다.
2. "확장에는 열려있고 변경에는 닫혀있는 객체 지향 원칙"을 설명해보세요
    변경에 닫혀있다는 기존 코드를 변경하지 않는다. 확장에 열려있다는 새로운 기능을 추가한다. 라는 의미 입니다.
    기존의 WhiteShip 생산에 변경 없이 BlackShip 을 생산한다.
3. 자바 8에 추가된 default 메소드에 대해 설명해보세요
    기존의 interface 에서는 기본적인 구현체를 만들 수 없었습니다, 항상 추상 메서드만 정의할 수 있었습니다.
    그래서 구현하는 클래스에서 메서드를 구현하거나 추상 클래스를 통해 구현해야 했습니다.
    이후에는 interface 를 구현하는 클래스, 상속받은 또 다른 interface 도 사용할 수 있습니다.
    이제는 추상 클래스의 장점을 인터페이스에서도 활용 할 수 있기에 추상 클래스보다 인터페이스를 더 사용하게 되었습니다.
    더욱 인터페이스에 private 메서드까지 추가 되어 활용도가 높아졌습니다.

실무에서는 ?
단순한 팩토리 패턴
    매개변수 값 또는 메소드에 따라 다른 인스턴스를 리턴하는 단순한 버전
    java.util.Calendar 또는 java.lang.NumberFormat
        cal = switch (caltype) {
            case "buddhist" -> new BuddhistCalendar(zone, aLocale);
            case "japanese" -> new JapaneseImperialCalendar(zone, aLocale);
            case "gregory"  -> new GregorianCalendar(zone, aLocale);
            default         -> null;
        };
        - 매개 변수에 따라 반환되는 인스턴스가 다르다, 나라 별로 캘린더가 달라서.
스프링 BeanFactory
    Object 타입의 Product 를 만드는 BeanFactory 라는 Creator !
    BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
    BeanFactory bf = new AnnotationConfigApplicationContext(Config.class);
    ...

BeanFactory 가 creator 이며, new ClassPathXmlApplicationContext, new AnnotationConfigApplicationContext 이와 같은 것들이 concreteProduct 이다.






```