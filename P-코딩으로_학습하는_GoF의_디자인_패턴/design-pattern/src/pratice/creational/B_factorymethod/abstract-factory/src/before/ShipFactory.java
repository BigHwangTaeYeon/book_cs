package before;

public interface ShipFactory {
    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmail(email, ship);
        return ship;
    }

    private void sendEmail(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    };

    Ship createShip();

    private void prepareFor(String name) {
        System.out.println(name + " 만드는 중");
    }

    private void validate(String name, String email) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요");
        }
        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요");
        }
    }
}
