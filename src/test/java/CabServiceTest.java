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
    public void givenLessDistanceOrTime_shouldReturnMinFare(){
        CabService invoiceGenerator = new CabService();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(5,fare);
    }

    @Test
    public void givenRides_ShouldReturnInvoiceSummary() {
        CabService cabService = new CabService();
        Ride[] rides = { new Ride(2.0, 5), new Ride(1.0, 5) };
        InvoiceSummary actualInvoiceSummary = cabService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Bhushan Mahajan";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(1,2)
        };
        CabService cabService = new CabService();
        cabService.addRides(userId, rides);
        InvoiceSummary actualInvoiceSummary = cabService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,42.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }
}
