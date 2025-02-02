```text
방문자 (Visitor) 패턴
    기존 코드를 변경하지 않고 새로운 기능을 추가하는 방법.
    • 더블 디스패치 (Double Dispatch)를 활용할 수 있다.
        Dispatch 란 다형성이나 분배 배치, 요청을 처리할 구체적인 클래스 구체적인 메소드를 찾아서 배치하는 것을 의미

        더블 디스패치라는 의미는 아래처럼
         1. 구체 클래스인 Rectangle 에서 accept 를 호출하여
         2. device.print(this); 어떤 디바이스 호출인지 런타임 중에 확인을 하게 된다. 
            Shape rectangle = new Rectangle();
            Device device = new Phone();
            rectangle.accept(device);

```
<img width="880" alt="Image" src="https://github.com/user-attachments/assets/bc3187f9-945c-4519-a1ed-5c57d26f92e7" />

```text

    장점
    • 기존 코드를 변경하지 않고 새로운 코드를 추가할 수 있다.
    • 추가 기능을 한 곳에 모아둘 수 있다.
    단점
    • 복잡하다.
    • 새로운 Element(Shape) 를 추가하거나 제거할 때 모든 Visitor(Device) 코드를 변경해야 한다.

    자바
    • FileVisitor, SimpleFileVisitor
    • AnnotationValueVisitor
    • ElementVisitor
    스프링
    • BeanDefinitionVisitor































```