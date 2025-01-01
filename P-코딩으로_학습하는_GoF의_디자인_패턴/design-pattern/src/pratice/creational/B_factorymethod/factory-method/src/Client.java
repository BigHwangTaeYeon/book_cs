import java.util.Calendar;

public class Client {
    public static void main(String[] args) {
        Ship abstractShipFactory = new WhiteShipFactoryForDefault().orderShip("abstract1", "abstract@name.com");
        System.out.println("abstractShipFactory = " + abstractShipFactory);

        Client client = new Client();
        client.print(new WhiteShipFactory(), "whiteShipPrint", "whitePrint@name.com");
        client.print(new BlackShipFactory(), "blackShipPrint", "blackPrint@name.com");

        Ship whiteShip = new WhiteShipFactory().orderShip("WhiteShip123", "white@name.com");
        System.out.println("whiteShip = " + whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("BlackShip123", "black@name.com");
        System.out.println("blackShip = " + blackShip);

        Calendar.getInstance();
    }

    // DI 라고 볼 수 있다, 이 부분만 별도의 클래스로 분리하여 처리한다면.
    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
