package B_after;

import java.time.LocalDateTime;

public class FrontDesk {
    private CleaningService cleaningService = new CleaningService();
    private Restaurant restaurant = new Restaurant();

    public void getTower(Guest guest, int num) {
        cleaningService.getTower(guest.getId(), num);
    }

    public String getRoomNumFor(Integer guestId) {
        return "1111";
    }

    public void dinner(Guest guest, LocalDateTime dateTime) {
        restaurant.dinner(guest.getId(), dateTime);
    }
}
