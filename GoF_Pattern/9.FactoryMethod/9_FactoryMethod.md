# FactoryMethod

객체 생성을 위한 패턴
객체 생성에 필요한 과정을 템플릿처럼 정해 놓고 각 과정을 다양하게 구현이 가능하다.
구체적으로 생성할 클래스를 유연하게 정할 수 있다.
객체 생성에 대한 인터페이스와 구현의 분리

객체 생성에 대한 인터페이스와 구현을 분리시킴으로써, 확장과 유지보수성을 높여준다.

<<abstract>>                                    <<interface>>
Factory                                         Item

ItemFactory                     Sword           Shield          Bow

<<abstract>>                                    <<interface>>
Factory                                         Item
생성에 대한 인터페이스

ItemFactory                     Sword           Shield          Bow
생성에 대한 구현

인터페이스와 구현은 별도의 패키지를 만들어 사용할 수 있다.

추가
FoodFactory 만들어 Factory를 상속받고,
Bread class, Milk class를 만들어 Item을 상속받는다.
FoodFactory는 Bread와 Milk를 생성할 수 있도록 하면 된다.