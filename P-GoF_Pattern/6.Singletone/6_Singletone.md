# Singletone

오직 하나의 객체만이 생성되도록 보장해주는 패턴

다른 클래스들에서 접근 할 수 있지만 생성은 못함

private King() {}
접근제한자 private으로 설정함으로써,
King king = new King();
위 코드처럼 일반적으로 사용하는 객체 생성을 생성자로 호출하지 못하게 하며,

System.out.println("King.hashCode() : " + king.hashCode());
System.out.println("King2.hashCode() : " + king2.hashCode());
위 코드 처럼 새로 가져온 객체에서 hascode값을 비교하였을 때, 같음을 알 수 있다.
