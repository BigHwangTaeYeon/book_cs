package B_after;

import A_before.TourPlan;

import java.time.LocalDate;
import java.util.Locale;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourBuilder();
        builder.title("kan kun");
        builder.nightsAndDays(2,3);

        TourPlanBuilder builder1 = new DefaultTourBuilder();
        builder1.title("놀러가장")
                .nightsAndDays(2,3)
                .startDate(LocalDate.of(2020, 12, 13))
                .whereToStay("리조트")
                .addPlan(0, "checkIn")
                .addPlan(1, "gogoo")
                .getPlan();

        TourPlan plan = builder1.title("놀러가장")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 13))
                .whereToStay("리조트")
                .addPlan(0, "checkIn")
                .addPlan(1, "gogoo")
                .getPlan();

        TourPlanBuilder builder2 = new DefaultTourBuilder();

        TourPlan longBeachTrip = builder2.title("long beach")
                .startDate(LocalDate.of(2024, 8, 12))
                .getPlan();

        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan1 = director.cancunTrip();
        TourPlan tourPlan2 = director.longBeach();

//        Stream.Builder<String> objectStreamBuilder = new Streams.StreamBuilderImpl<>();
        Stream.Builder<String> string = Stream.builder();
        Stream<String> names = Stream.<String>builder().add("test").add("test").build();
        Stream<String> names1 = string.add("test").add("test").build();
        names.forEach(System.out::println);
    }
}
