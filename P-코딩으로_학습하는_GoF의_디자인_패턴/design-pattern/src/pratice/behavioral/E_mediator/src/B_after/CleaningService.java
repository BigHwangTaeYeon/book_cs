package B_after;

public class CleaningService {
    private FrontDesk frontDesk = new FrontDesk();

    public void getTower(Integer guestId, int num) {
        String roomNum = this.frontDesk.getRoomNumFor(guestId);
        System.out.println("roomNum + num = " + roomNum + num);
    }
}
