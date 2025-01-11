```text

추상 팩토리 (Abstract factory) 패턴
    서로 관련있는 여러 객체를 만들어주는 인터페이스
    구체적으로 어떤 클래스의 인스턴스를 (concrete product)를 사용하는지 감출 수 있다.

팩토리 메서드 패턴에 클라이언트만 추가 되었기 때문에 굉장히 유사한 형태이다.

장단점
    팩토리 메서드 패턴 (구체적인 인스턴스를 만드는 방법에 초점)
        구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다.
        다양한 구현체(Product)가 있고 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.
        구체적인 타입(concrete class)의 인스턴스를 만드는 과정을 concrete factory 로 숨기고 
        concrete factory 를 제공
    
    추상 팩토리 패턴 (팩토리를 사용하는 방법에 초점)
        팩토리를 사용하는 쪽, 클라이언트 관점으로 보는 것.
        팩토리를 통해서 추상화된 인터페이스만 클라이언트가 쓸 수 있도록 해주기에
        클라이언트 입장에서 concrete class 를 직접 참조해서 사용할 필요가 없다.
    
    둘 다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공한다.
    관점이 다르다.
        팩토리 메서드 패턴은 팩토리를 구현하는 방법(inheritance)에 초점을 둔다.
        추상 팩토리 패턴은 팩토리를 사용하는 방법(composition)에 초점을 둔다.
    목적이 다르다.
        팩토리 메서드 패턴은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적.
            concrete class 의 인스턴스 생성하는 과정을 구체적인 factory, 하위 클래스 또는 인터페이스 구현하는 class 로 옮기는 것이 목적
        추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적.
            관련있는 여러 오브젝트를 만들어주는 factory 를 추상화 시켜서 사용할 수 있게 끔 만들어주는 것.
            구체적인 타입이나 구체적인 클래스에 의존하지 않게 끔.

실무
    자바 라이브러리
        javax.xml.xpath.XPathFactory#newInstence()
        javax.xml.transform.TransformerFactory#newInstence()
        javax.xml.parsers.DocumentBuilderFactory#newInstence()
```
```java
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = (Document) builder.parse(new File("src/main/resource/config.xml"));
```
```text
    스프링
        FactoryBean 과 그 구현체
```
```java
    public class ShipFactoryBean implements FactoryBean<Ship>{
        @Override
        public Ship getObject() throws Exception {
            Ship ship = new WhiteShip();
            ship.setName("WhiteShip");
            return ship;
        }
        @Override
        public Class<?> getObjectType() {
            return Ship.class;
        }
    }
```
```text
        추상 팩토리 패턴으로 구현되어있는 FactoryBean interface 를 상속받아서 빈으로 등록.
        클라이언트에 제공할 Ship 이라는 인스턴를 빈으로 생성하는데, 복잡하다면 복잡하다면 사용할 만 하다.
```