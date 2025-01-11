package before;

public class ShipFactoryBean implements FactoryBean<Ship>{
    @Override
    public Ship getObject() throws Exception {
        Ship ship = new WhiteShip();
        ship.setName("WhiteShip");
        return ship;
    }
    @Override
    public Class<?> getObjectType() {
        return Ship.class;
    }
}
