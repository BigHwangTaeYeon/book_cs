package B_after;

public class Triangle implements Shape {
    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
