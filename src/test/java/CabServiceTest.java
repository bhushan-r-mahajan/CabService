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
}
