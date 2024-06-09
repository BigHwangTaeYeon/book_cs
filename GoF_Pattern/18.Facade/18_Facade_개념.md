파사드 패턴이란?
파사드 패턴은 일련의 저수준 인터페이스들을 하나의 고수준 인터페이스로 묶어주는 패턴이다. 
클라이언트 객체가 여러 저수준 인터페이스의 동작을 제어 하려면 여러 저수준 인터페이스의 메서드들을 일일히 호출해야 하는데, 
파사드 패턴을 이용하면 고수준 인터페이스의 메서드 호출 만으로 한 번에 할 수 있게 된다.

*파사드 패턴에서는 고수준 인터페이스를 저수준 인터페이스를 통합했다 해서 '통합 인터페이스'라고 부른다.

저수준 인터페이스를 바꾸기 위해서 다른 인터페이스를 건드리지 않고 
통합 인터페이스의 코드만 건드리면 되므로 
클라이언트 객체는 여러 저수준 인터페이스에 대해 의존성이 느슨해진다.

파사드 패턴을 쓰지 않았을 때의 문제점
예를 들어 우리가 커피를 만든다고 해보자. 
커피를 만들기 위해서는 원두를 냉동실에서 꺼낸 다음, 원두를 갈고, 간 원두를 필터에 놓은 후, 뜨거운 물을 만들고, 물을 부어서 만든다.

그러면 위의 과정은 다음과 같이 정리될 수 있다.

```kotlin
class Person(
val refrigerator : Refrigerator = Refrigerator()
val grinder : Grider = Grider()
val filter : Filter = Filter()
val waterPurifier : WaterPurifier = WaterPurifier()
) {
fun makeCoffee() : Coffee {
val coffeeBean = refrigerator.getCoffeeBrean() // 냉장고에서 커피콩 꺼내기
val grindedCoffeeBean = grinder.grindCoffeeBean(coffeeBean) // 커피 갈기
filter.put(grindedCoffeeBean) // 커피를 필터 위에 놓기
val hotWater = waterPurifier.getHotWater() // 뜨거운 물 뽑기
val coffeee = putWaterToFilter(filter, hotWater) // 커피 만들기

        return coffee
    }
}
```

하지만 이렇게 하면 Person 클래스는 Refrigerator, Grinder, Filter, WaterPurifier 모두에 의존성을 가져야지 커피를 만들 수 있다. 
이 말은 Low Level의 객체들을 모두 일일히 제어해야 한다는 뜻이다. 
이런 객체는 많은 객체에 의존성을 갖게 되기 때문에 문제가 생길 수 밖에 없다.

파사드 패턴을 사용한 문제 해결
위의 문제를 해결하는 것이 바로 파사드 패턴이다. 파사드 패턴은 저수준 객체들을 깔끔하게 감싼 고수준 객체를 만들어 위의 문제를 해결한다.

위에서 커피를 만들기 위해 냉장고, 그라인더, 필터, 커피콩, 커피 등의 클래스에 의존성을 가졌는데 
이 의존성을 Coffee를 만들기 위한 CoffeeMaker 객체로 몰아 넣는다.
```kotlin
interface CoffeeMaker {
fun makeCoffee() : Coffee
}

class CoffeeMakerImpl(
val refrigerator : Refrigerator = Refrigerator()
val grinder : Grider = Grider()
val filter : Filter = Filter()
val waterPurifier : WaterPurifier = WaterPurifier()
): CoffeeMaker {
fun makeCoffee() : Coffee {
val coffeeBean = refrigerator.getCoffeeBrean() // 냉장고에서 커피콩 꺼내기
val grindedCoffeeBean = grinder.grindCoffeeBean(coffeeBean) // 커피 갈기
filter.put(grindedCoffeeBean) // 커피를 필터 위에 놓기
val hotWater = waterPurifier.getHotWater() // 뜨거운 물 뽑기
val coffeee = putWaterToFilter(filter, hotWater) // 커피 만들기

        return coffee
    }
}
```

즉, CoffeeMaker은 Coffee를 만들기 위한 고수준 객체가 되며, 
사람은 coffeeMaker만 있으면 커피를 만들 수 있게 된다.
```kotlin
class Person() {
val coffeeMaker : CoffeeMaker = CoffeeMakerImpl()

    fun makeCoffee() : Coffee {
    	return coffeeMaker.makeCoffee()
    }
}
```

즉, 낮은 레벨의 객체들을 모두 하나의 고수준 객체로 감쌈으로서 저수준 객체인 냉장고, 그라인터, 필터등이 바뀌더라도 
사람(Person)은 신경을 쓸 필요가 없어진다. 
CoffeeMaker만을 바꾸어서 사용하면 된다.

파사드 패턴의 장점과 문제점
파사드 패턴은 클라이언트 인터페이스 디자인을 위한 필수 패턴이다. 
클라이언트는 복잡한 인터페이스를 싫어하며, 필요한 기능만 들어간 단순한 인터페이스를 선호한다. 
인터페이스가 단순해질 수록 문제 또한 줄어들며 코드도 간단해진다. 
내부의 복잡한 동작을 모두 Wrapping 시켜서 외부에는 간단한 동작만을 공개하면 잘 설계한 인터페이스라 하는데 파사드 패턴은 이것을 가능하게 한다.

문제점은 파사드 패턴을 사용하면 고수준 객체가 너무 복잡해진다는 것이다. 
따라서 고수준 객체에 넣어야 하는 저수준 객체들 또한 최대한 간단하게 만들어 넣는 방식으로 설계해야 파사드 패턴의 복잡도를 줄일 수 있다. 
파사드 패턴이라고 절대로 모든 저수준 객체를 넣어서 만드는 것이 아니다. 

어떤 저수준 객체는 다른 객체에게는 고수준 객체일 수 있으며, 고수준 객체는 다른 고수준 객체의 저수준 객체일 수 있다. 
이러한 객체의 계층화를 최대한 연관성 있는 객체들끼리 시킴으로써 고수준 객체를 잘 설계할 수 있다.
