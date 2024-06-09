# Command

하나의 명령(기능)을 객체화한 패턴

객체는 전달할 수 있고 보관할 수 있다.
즉, 명령(기능)을 전달하고 보관할 수 있게 된다.

배치 실행, Undo/Redo(이미 실행된 기능을 되돌리거나 다시 실행), 우선순위가 높은 명령을 먼저 실행하기 등이 가능해진다.

메서드의 인자를 통해 전달할 수 있고 메모리에 보관할 수 있다.
DBMS에도 저장이 가능해진다
데이터가 아닌 행위를 전달할 수 있다.
네트워크 통해 또다른 기능을 수행할 수 있다.

CommandGroup Class에서 ArrayList로 받아 index로 우선순위를 정하여 실행이 가능하다.

Clear, Print, Move, Color 각 기능들을 Command interface에서 상속받아 생성자로 받아 놓고,
CommandGroup Class에서 run 매서드를 담아 순서대로 실행을 한다.