package B_after;

import java.time.LocalDateTime;

public class Guest {
    private Integer id;
    private FrontDesk frontDesk = new FrontDesk();

    public void getTower(int num) {
        this.frontDesk.getTower(this, num);
    }

    public void dinner(LocalDateTime dateTime) {
        this.frontDesk.dinner(this, dateTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
