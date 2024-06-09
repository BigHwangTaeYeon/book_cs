package test;

public abstract class DiceUnit {
    private String name;

    public DiceUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "[ Name : " + this.name + ", Number : " + getNumber() + " ]";
    }

    public abstract int getNumber();
}
