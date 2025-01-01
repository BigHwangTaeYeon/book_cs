public abstract class DefaultShipFactory implements ShipFactoryForDefault{
    @Override
    public void sendEmail(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었어용");
    }
}
