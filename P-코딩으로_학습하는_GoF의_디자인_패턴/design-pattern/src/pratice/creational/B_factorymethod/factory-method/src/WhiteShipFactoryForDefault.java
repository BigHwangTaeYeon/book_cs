public class WhiteShipFactoryForDefault extends DefaultShipFactory {
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
