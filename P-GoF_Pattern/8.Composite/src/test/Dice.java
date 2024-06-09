package test;

public class Dice extends DiceUnit {
    
    private int num;

    public Dice(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    public int getNumber() {
        return this.num;
    }
    
}
