package prac;

public class AudioAdapter extends Machine {
    private String part;

    public AudioAdapter(String part) {
        super(part);
        this.part = part;
    }

    @Override
    public void operate() {
        int frequency = 0;
        switch (part) {
            case "A part":
                frequency = 500;
                break;
            case "B part":
                frequency = 2000;
                break;
            case "C part":
                frequency = 4000;
                break;
        
            default:
                System.out.println(part + "가 잘못 되었습니다.");
                break;
        }
        AudioMachine am = new AudioMachine(part, frequency);
        am.print();
    }
    
}
