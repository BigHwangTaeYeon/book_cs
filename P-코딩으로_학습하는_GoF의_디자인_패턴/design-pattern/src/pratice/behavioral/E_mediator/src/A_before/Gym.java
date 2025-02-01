package A_before;

public class Gym {
    private CleaningService cleaningService = new CleaningService();

    public void clean() {
        cleaningService.clean(this);
    }
}
