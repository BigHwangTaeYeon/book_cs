package B_after;

public class Client {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        Device device = new Phone();
        rectangle.accept(device);
    }
}
