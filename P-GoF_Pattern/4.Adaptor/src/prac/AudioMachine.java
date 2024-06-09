package prac;

public class AudioMachine {
    private String part;
    private int frequency;
    
    public AudioMachine(String part, int frequency) {
        this.part = part;
        this.frequency = frequency;
    }

    public void print() {
        System.out.println(part + " 주파수는 " + frequency + "Hz 입니다.");
    }
}
