package practice.machine;

public class CarMachine implements Machine {
    private int money;
    private int quantity;
    private CarMachine() {}
    private static class instance{
        private static final CarMachine carMachine = new CarMachine();
    }

    public static CarMachine getInstance(int money, int quantity) {
        instance.carMachine.money = money;
        instance.carMachine.quantity = quantity;
        return instance.carMachine;
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
