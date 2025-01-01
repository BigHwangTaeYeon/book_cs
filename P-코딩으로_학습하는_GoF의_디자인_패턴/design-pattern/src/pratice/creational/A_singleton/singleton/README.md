
시스템 런타임, 환경 세팅 정보 등
인스턴스를 하나만 만들어 사용

디자인 패턴

싱글톤
일반적인 조건절 또는 static 으로 생산하는 것은 역직렬화에서는 대응 방법이 있지만 리플랙션에 대해서는 방법이 없다.
단순하게 리플랙션에 대응하기 위해서는 열거형, enum 이다
시도하면 reflect.Constructor.newInstanceWithCaller 이렇게 오류가 난다.
enum 은 reflection 하지 못하도록 막아 두었다.
enum 은 기본적으로 serializable 을 구현하고 있다. 보이지는 않지만 Enum 을 상속받기 때문이다. (byte code 로 보면 extends java/lang/Enum 이렇게 되어있다.)
    public abstract class Enum<E extends Enum<E>> implements Constable, Comparable<E>, Serializable {...}
enum 의 단점은 미리 만들어진다, 그리고 상속을 쓰지 못한다. 오로지 enum 만 상속할 수 있으며 그것도 compile 할 때 가능하다.

특정한 클래스를 상속받아 사용해야한다면, 스태틱한 inner class 로 Holder 를 사용하는 방법밖에 없다. 또 Lazy loading 까지 생각한다면 Holder 밖에 없다.

	질문
	1. 자바에서 enum 을 사용하지 않고 싱글톤 패턴을 구현하는 방법은 ?
	2. private 생성자와 static 메소드를 사용하는 방법의 단점은 ?
	3. enum을 사용하여 싱글톤 패턴을 생성하는 방법의 장점과 단점은 ?
	4. static inner 클래스를 사용해 싱글톤 패턴을 구현하라.

	실무에서는 ?
	1. 스프링에서 빈 스코프 중에 하나로 싱글톤 스코프
		엄밀히 따지면 싱글톤 패턴과 다르다.
		인스턴스를 ApplicationContext안에서 관리해주는 것 뿐이다.
	2. 자바 java.lang.Runtime
	3. 다른 디자인 패턴(빌더, 파사드, 추상 팩토리 등) 구현체의 일부로 쓰이기도 한다.