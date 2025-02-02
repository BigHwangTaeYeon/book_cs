package B_after;

public class Watch implements Device {
    @Override
    public void print(Triangle triangle) {
        System.out.println("watch Triangle");

    }
    @Override
    public void print(Rectangle rectangle) {
        System.out.println("watch Rectangle");

    }
}
