# Adaptor

어떤 클레스를 사용해야하는데,
이 클래스에 대한 코드를 변경할 수 없는 상황에서도 Adaptor Pattern을 적용해서 사용할 수 있도록 해준다.

    Animal          <-      User(Main)
 <<abstract>>

  Dog     Cat       TigerAdapter    <- Tiger
 Class   Class         Class

TigerAdapter Class는 Animal을 상속받아 사용한다.
구현체는 Tiger Class로 TigerAdapter에서 인스턴스를 생성자로 만들어 사용한다.