import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        SmartHome home = new SmartHome();
        try (Scanner scanner = new Scanner(System.in)) {
            do{
                home.report();

                System.out.println("[1] 문 열기");
                System.out.println("[2] 문 닫기");
                System.out.println("[3] 창문 열기");
                System.out.println("[4] 창문 닫기");
                System.out.println("[5] 에어컨 켜기");
                System.out.println("[6] 에어컨 끄기");
                System.out.println("[7] 보일러 켜기");
                System.out.println("[8] 보일러 끄기");
                
                System.out.println("명령 : ");
                int i = scanner.nextInt();

                switch (i) {
                    case 1:
                        home.door.open();
                        break;
                    case 2:
                        home.door.close();
                        break;
                    case 3:
                        home.window.open();
                        break;
                    case 4:
                        home.window.close();
                        break;
                    case 5:
                        home.aircon.on();
                        break;
                    case 6:
                        home.aircon.off();
                        break;
                    case 7:
                        home.boiler.on();
                        break;
                    case 8:
                        home.boiler.off();
                        break;
                }

            } while (true);
        }

    }
}
