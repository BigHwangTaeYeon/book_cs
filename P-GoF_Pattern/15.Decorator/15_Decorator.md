# Decorator

장식하는 사람
기능을 마치 장식처럼 계속 추가할 수 있는 패턴
기능을 실행 중에 동적으로 변경 또는 확장 할 수 있는 패턴

모든 클레스의 최상위 부모는 Item class이며,
Decorator class에서는 Item class를 생성자로 만들어 주는 역할만 함으로써
여러 하위 클래스에서 사용을 돕는다.

자식 클래스인 Strings class에서 문자열을 리스트로 저장하여,
Decorator 하위 클래스에서 Strings 문자열을 여러가지 방식으로 사용한다.