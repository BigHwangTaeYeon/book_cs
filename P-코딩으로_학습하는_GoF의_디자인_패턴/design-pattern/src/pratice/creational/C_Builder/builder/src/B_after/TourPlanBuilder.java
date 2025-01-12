package B_after;

import A_before.TourPlan;

import java.time.LocalDate;

public interface TourPlanBuilder {
    // Builder 를 통해 메서드 체이닝을 활용하기 위함
    TourPlanBuilder title(String title);
    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder startDate(LocalDate localDate);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);

    // return 용도
    TourPlan getPlan();
}
