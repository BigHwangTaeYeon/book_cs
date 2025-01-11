package ship;

import before.Ship;
import before.WhiteShip;

public class WhiteShipFactory //extends DefualtShipFactory
{
    private final ShipPartFactory shipPartFactory;

    public WhiteShipFactory(ShipPartFactory shipPartFactory) {
        this.shipPartFactory = shipPartFactory;
    }

//    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartFactory.createAnchor());
        ship.setWheel(shipPartFactory.createWheel());
        return ship;
    }
}
