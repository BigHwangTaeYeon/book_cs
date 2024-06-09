package test;

public class Deposit {
    private int money;
    private String name;

    public Deposit(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney(){
        return this.money;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + money + ")";
    }
}
