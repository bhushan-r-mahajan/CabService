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
        CabService invoiceGenerator = new CabService();
        Ride[] rides = {
                new Ride(2.0, 5, PremiumRides.NORMAL),
                new Ride(0.1, 1, PremiumRides.NORMAL)
        };
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Bhushan";
        Ride[] rides = {
                new Ride(2.0, 5, PremiumRides.NORMAL),
                new Ride(0.1, 1, PremiumRides.NORMAL),
                new Ride(1, 2, PremiumRides.NORMAL)
        };
        CabService invoiceGenerator = new CabService();
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,42.0);
        Assertions.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserIdAndRidesForTwoCategoriesRides_ShouldReturnInvoiceSummary() {
        String userId = "Bhushan";
        Ride[] rides = {
                new Ride(2.0, 5, PremiumRides.NORMAL),
                new Ride(0.1, 1, PremiumRides.PREMIUM),
                new Ride(2, 2, PremiumRides.PREMIUM)
        };
        CabService invoiceGenerator = new CabService();
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 79);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}

