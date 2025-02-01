package A_before;

public class Restaurant {
    private CleaningService cleaningService = new CleaningService();

    public void dinner(Guest guest) {
        System.out.println("guest = " + guest);
    }

    public void clean() {
        cleaningService.clean(this);
    }
}
