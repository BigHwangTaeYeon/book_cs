import java.util.ArrayList;

public class Walker {
    // walker 현재 위치 좌표
    private int currentX, currentY;
    // walker가 도달해야할 목표 좌표
    private int targetX, targetY;
    // 시작 좌표에서 목표 좌표로 가기 위한 어떠한 액션을 취해야하는지 순서대로 담는 배열
    private ArrayList<String> actionList = new ArrayList<String>();

    public Walker(int currentX, int currentY, int targetX, int targetY) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public double walk(String action) {
        actionList.add(action);

        switch (action) {
            case "UP":
                currentY += 1;
                break;
            case "RIGHT":
                currentX += 1;
                break;
            case "DOWN":
                currentY -= 1;
                break;
            case "LEFT":
                currentX -= 1;
                break;
        }
        // Math.sqrt(double d) d의 제곱근을 반환합니다 ex) 9의 제곱근 3.0
        // Math.pow(double a, double b) 거듭제곱한 첫 번째 인수의 값을 반환합니다. ex) a=3 b=2 return 9.000000 / a=3 b=3 return 27.000000
        return Math.sqrt(Math.pow(currentX - targetX, 2) + Math.pow(currentY - targetY, 2));
    }
    
    // walker iner class
    // walker class에서만 생성할 수 있도록 하고, 오직 walker class에서만이 변경할 수 있도록 하기 위함
    public class Memento {
        private int x, y;
        private ArrayList<String> actionList;
        private Memento() {}
    }

    public Memento createMemento() {
        Memento memento = new Memento();

        memento.x = this.currentX;
        memento.y = this.currentY;
        memento.actionList = (ArrayList<String>) this.actionList.clone();

        return memento;
    }

    // walker의 상태를 변경하는 method
    public void restoreMemento(Memento memento) {
        this.currentX = memento.x;
        this.currentY = memento.y;
        this.actionList = (ArrayList<String>) memento.actionList.clone();
    }

    @Override
    public String toString() {
        return actionList.toString();
    }

}
