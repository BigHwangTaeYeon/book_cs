package A_before;

public class Button {
    private Light light;

    public Button(Light light) {
        this.light = light;
    }

    public void press() {
        light.on();
    }

    public static void main(String[] args) {
        Button button = new Button(new Light());
        button.press();
    }
}
