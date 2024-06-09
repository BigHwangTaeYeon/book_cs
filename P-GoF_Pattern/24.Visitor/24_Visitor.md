# Visitor

데이터 구조와 데이터 처리를 분리해주는 패턴

데이터 나타내는 Class가 있다면, 이 데이터를 처리하는 코드는 해당 데이터 Class에 메소드로 구현하는 것이 쉬워 보인다.
그러나 Visitor Pattern은 데이터를 처리하는 방식을 메소드가아닌 별도의 Class로 구현한다.

이렇게 데이터 구조와 처리하는 방법을 별도의 Class로 분리해줌으로써,
새로운 데이터 처리방식을 추가할 때, 기존의 소스코드 변경 없이 새로운 Class 추가만으로 기능 확장이 용이하다.

데이터 구조는 Composite Pattern을 사용함으로써, 단일 데이터와 단일 데이터로 구성되는 집합 데이터를 표현할 수 있다.

Unit interface와 Item, ItemList Class가 데이터 구조
Visitor interface와 SumVisitor, AvgVisitor Class가 데이터 처리

ItemList에 Item instance를 담아 list로 보관 후, sum 또는 avg에서 사용 시 List를 Item으로 변환하여 작업한다.