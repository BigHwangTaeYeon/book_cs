package A_before;

public class Triangle implements Shape{
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("phone Triangle");
        } else if (device instanceof Watch) {
            System.out.println("watch Triangle");
        }
    }
}
