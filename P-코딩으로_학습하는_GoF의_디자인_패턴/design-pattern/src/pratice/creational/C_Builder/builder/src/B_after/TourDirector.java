package B_after;

import A_before.TourPlan;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip() {
        return tourPlanBuilder
                .title("놀러가장")
                .nightsAndDays(2,3)
                .startDate(LocalDate.of(2020, 12, 13))
                .whereToStay("리조트")
                .addPlan(0, "checkIn")
                .addPlan(1, "gogoo")
                .getPlan();
    }

    public TourPlan longBeach() {
        return tourPlanBuilder
                .title("long beach")
                .startDate(LocalDate.of(2024, 8, 12))
                .getPlan();
    }

}
