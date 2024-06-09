package practice.machine;

public class TrainMachine implements Machine {
    private int money;
    private int quantity;
    private TrainMachine() {}
    private static class instance {
        private static final TrainMachine trainMachine = new TrainMachine();
    }
    
    public static TrainMachine getInstance(int money, int quantity) {
        instance.trainMachine.money = money;
        instance.trainMachine.quantity = quantity;
        return instance.trainMachine;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void sell(int quantity) {
        quantity--;
    }

    @Override
    public void make(int quantity) {
        quantity++;
    }
    
}
