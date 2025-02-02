```text
전략 (Strategy) 패턴 (은연중에 자주 사용하는 패턴)
    여러 알고리듬을 캡슐화하고 상호 교환 가능하게 만드는 패턴.
    • 컨텍스트에서 사용할 알고리듬을 클라이언트 선택한다.

```
<img width="720" alt="Image" src="https://github.com/user-attachments/assets/f258fa21-6acb-4fb5-8f64-503aa85ecc9a" />

```text

    BlueLightRedLight Context 에 해당
    speed 가 전략에 해당
    

    장점
    • 새로운 전략을 추가하더라도 기존 코드를 변경하지 않는다.
    • 상속 대신 위임을 사용할 수 있다. (생성자가 아닌 메서드에 파라미터로 Normal, Faster 를 선택할 있다.)
    • 런타임에 전략을 변경할 수 있다.
    단점
    • 복잡도가 증가한다.
    • 클라이언트 코드가 구체적인 전략을 알아야 한다.

    자바
    • Comparator
    스프링
    • ApplicationContext
    • PlatformTransactionManager
```