package prac;

public class ComputerMachine extends Machine {
    
    private String part;

    public ComputerMachine(String part) {
        super(part);
        this.part = part;
    }

    @Override
    public void operate() {
        System.out.println(part + " 컴퓨터가 시작됩니다.");
    }
    
}
