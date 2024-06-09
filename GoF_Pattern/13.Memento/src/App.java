import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        //
        Walker walker = new Walker(0, 0, 10, 10);
        //
        String[] actions = { "UP", "RIGHT", "DOWN", "LEFT" };
        // walker 행위를 무작위로 정의하기 위함
        Random random = new Random();
        // 현재 좌표에서 목표좌표까지 최소 길이를 계속 확인
        // 최대값인 minDistance 정의
        double minDistance = Double.MAX_VALUE;
        // 앞으로 생성할 walker memento 객체를 null 값으로 지정
        Walker.Memento memento = null;

        while (true) {
            String action = actions[random.nextInt(4)];
            double distance = walker.walk(action);
            System.out.println(action + " " + distance);

            if (distance == 0.0)
                break;
            if (minDistance > distance) {
                minDistance = distance;
                // Walker class를 통해서만 Memento객체를 생성할 수 있다.
                memento = walker.createMemento();
            } else {
                if (memento != null)
                    walker.restoreMemento(memento);
            }
        }
        
        System.out.println("Walker's path : " + walker);

    }
}
