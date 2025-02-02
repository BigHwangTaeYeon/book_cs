package B_after;

public class Phone implements Device {
    @Override
    public void print(Triangle triangle) {
        System.out.println("phone Triangle");

    }
    @Override
    public void print(Rectangle rectangle) {
        System.out.println("phone Rectangle");

    }
}
