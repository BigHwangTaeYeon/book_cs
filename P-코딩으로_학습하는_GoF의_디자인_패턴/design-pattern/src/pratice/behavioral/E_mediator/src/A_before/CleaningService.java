package A_before;

public class CleaningService {
    public void getTower(Guest guest, int numberOfTower) {
        System.out.println("numberOfTower + g = " + numberOfTower + guest);
    }

    public void clean(Gym gym) {
        System.out.println("gym = " + gym);
    }

    public void clean(Restaurant restaurant) {
        System.out.println("clean" + restaurant);
    }
}
