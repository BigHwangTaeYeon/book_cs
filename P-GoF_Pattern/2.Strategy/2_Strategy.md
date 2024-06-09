# Strategy

전략패턴
하나의 기능을 구성하는 특정 부분을 실행중에 다른 것으로 효과적으로 변경할 수 있는 방안을 제공.
필요할 경우, 전략을 변경할 수 있다.

SumPrinter
    1~ 어떤 수까지 총 합 구해주는 Class
SumStrategy
    총 합은 interface에서 얻어온다.
SimpleSumStrategy
GaussSumStrategy
    구현체

SumPrinter에서 매개변수로 SumStrategy interface와 어떠한 수를 받아
Print 해준다.