# Iterator

동일한 형태의 데이터 항목을 여러개 가지고 있는 것을 Container / Aggregator라고 한다.
    Aggregator 형태
    - Array
    - Linked List
    - Tree
    - Graph
    - Table (DBMS)
    ...

Aggregator 구성 데이터를 하나씩 가져와야할 때, Aggregator의 종류에 따라 방법이 다를 수 밖에 없음.
Aggregator의 내부 자료 구조가 종류에 따라 모두 다르기 때문이다.

Array은 index로, LinkedList는 첫번째 데이터를 통해 연결된 데이터를 가져오는 방법으로 가져오기때문.

통일된 하나의 방법으로 구성 데이터를 가져오기위해 사용할 수 있는 패턴이 Iterator Pattern이다

다양한 형태의 컨테이너, 즉 Aggregator의 구성 데이터를 참조할 수 있는
표준화된 공통 API를 제공할 수 있다.
이렇게 되면 개발자는 다양한 데이터 구조를 파악하지 않아도 표준화된 한개의 API만으로도
다양한 구조의 Aggregator의 구성 데이터를 참조할 수 있게 된다.

Array Class에 Item Instance를 넣어 보관하고,
Iterator interface를 활용하여 하나씩 꺼내어 Item Class로 형변환하여 method를 활용한다.



Class Diagram (UML)