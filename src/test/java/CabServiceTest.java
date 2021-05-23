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
    public void givenRides_ShouldReturnInvoiceSummary() {
        CabService cabService = new CabService();
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        InvoiceSummary actualInvoiceSummary = cabService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }
}
