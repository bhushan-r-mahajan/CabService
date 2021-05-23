public class CabService {
    public double calculateFare(double distance, int time) {
        double fare;
        if (distance <= 1.0) {
            System.out.println("The Distance is very less so Minimum fare is '5 Rs' !!");
            fare = 5;
        } else {
            fare = ((distance * 10) + (time));
            System.out.println("The Fare for distance = '" + distance + "Km' and time = '" + time + "Mins' is equal to = '" + fare + "Rs'");
        }
        return fare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        System.out.println("The Total fare for all the rides is = '" + totalFare + "Rs'");
        return totalFare;
    }
}
