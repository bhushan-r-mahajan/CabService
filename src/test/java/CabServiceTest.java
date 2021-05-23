import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabServiceTest {
    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabService cabService = new CabService();
        double distance = 2.0;
        int time = 5;
        double fare = cabService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare);
    }

    @Test
    void givenMultipleRides_ShouldReturnAggregateFare() {
        CabService cabService = new CabService();
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.4, 5),
                         new Ride(5.0, 9)
                       };
        double totalAggregate = cabService.calculateFare(rides);
        Assertions.assertEquals(89, totalAggregate );
    }
}
