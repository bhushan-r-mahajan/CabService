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
}
