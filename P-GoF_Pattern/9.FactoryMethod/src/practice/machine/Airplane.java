package practice.machine;

public class Airplane implements Machine {
    private int money;
    private int quantity;
    private Airplane() {}
    private static class instance {
        private static final Airplane airplane = new Airplane();
    }

    public static Airplane getInstance(int money, int quantity) {
        instance.airplane.money = money;
        instance.airplane.quantity = quantity;
        return instance.airplane;
    }

    @Override
    public int getMoney() {
        return this.money;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void sell(int quantity) {
        this.quantity--;
    }

    @Override
    public void make(int quantity) {
        this.quantity++;
    }
    
}
