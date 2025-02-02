package A_before;

public class Rectangle implements Shape{
    @Override
    public void printTo(Device device) {
        if (device instanceof Phone) {
            System.out.println("phone Rectangle");
        } else if (device instanceof Watch) {
            System.out.println("watch Rectangle");
        }
    }
}
