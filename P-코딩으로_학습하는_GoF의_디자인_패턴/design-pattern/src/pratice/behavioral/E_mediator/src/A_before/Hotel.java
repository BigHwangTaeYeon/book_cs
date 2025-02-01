package A_before;

import B_after.Guest;

import java.time.LocalDateTime;

public class Hotel {
    public static void main(String[] args) {
        Guest guest = new Guest();
        guest.getTower(3);
        guest.dinner(LocalDateTime.now());

//        Restaurant restaurant = new Restaurant();
//        restaurant.clean();
    }
}
