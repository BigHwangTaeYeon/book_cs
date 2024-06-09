package prac;

public abstract class Machine {

    private String part;

    public Machine(String part) {
        this.part = part;
    }
    
    public abstract void operate();
}
