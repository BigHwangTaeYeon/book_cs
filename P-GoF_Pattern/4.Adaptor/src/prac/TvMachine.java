package prac;

public class TvMachine extends Machine {

    private String part;

    public TvMachine(String part) {
        super(part);
        this.part = part;
    }

    @Override
    public void operate() {
        System.out.println(part + " TV가 켜집니다.");
    }
    
}
