# Template

어떤 기능에 대해 실행 되어야 할 각 단계에 대한 순서만을 정의해 놓음.
각 단계에 맞게 새부 구현을 상황에 맞게 다르게 구현할 수 있게 하는 패턴.

            단계 1
            단계 2
            단계 3
단계 1 단계 2 단계 3 순서로 실행되는 기능
(각 단계에 대한 구체적인 코드 구현은 없음)
DisplayArticleTemplate Class <<abstract>>
    
    단계 1                  단계 1
    단계 2                  단계 2
    단계 3                  단계 3

    구현 A                  구현 B
SimpleDisplayArticle    CaptionDisplayArticle

A와 B가 다르게 구현되어 있는 경우,
상황에 맞게 A또는 B로 구현


```java
abstract class DisplayArticleTemplate

public final void display() {
    title();
    content();
    footer();
}
protected abstract void title();
protected abstract void content();
protected abstract void footer();
```
DisplayArticleTemplate class에서 final로 단계별 순서를 정해두고,
구현체는 상속받는 Class에서 메소드를 구현한다.