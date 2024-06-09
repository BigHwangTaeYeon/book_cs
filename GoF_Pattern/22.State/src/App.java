import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("플레이어의 상태 : " + player.getState().getDescription() + " / 속도 : " + player.getSpeed() + "km/h");
            System.out.println("[1] 제자리 서기 [2] 앉기 [3] 걷기 [4] 뛰기 [5] 종료 : ");

            String input = scanner.next();
            System.out.println();

            switch (input) {
                case "1":
                    player.getState().standUp();
                    break;
                case "2":
                    player.getState().sitDown();
                    break;
                case "3":
                    player.getState().walk();
                    break;
                case "4":
                    player.getState().run();
                    break;
                case "5":
                    break;
            }
            if ("5".equals(input)) break;
        }
        scanner.close();

    }
    
}
