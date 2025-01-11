package before;

import ship.WhitePartsProFactory;

public class WhiteShipFactory implements ShipFactory {
    private final WhitePartsProFactory whitePartsProFactory;

    public WhiteShipFactory(WhitePartsProFactory whitePartsProFactory) {
        this.whitePartsProFactory = whitePartsProFactory;
    }

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
