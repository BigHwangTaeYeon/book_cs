public class SumVisitor implements Visitor{
    private int sum = 0;

    public int getValue() {
        return sum;
    }

    @Override
    public void visit(Unit unit) {
        if (unit instanceof Item) {
            // 방문한 데이터가 Item Class라면 정수값을 갖는다
            sum += ((Item)unit).getValue();
        } else {
            // 단일 데이터가 아니라면, unit에서 accept method 호출
            unit.accept(this);
        }
    }
    
}
