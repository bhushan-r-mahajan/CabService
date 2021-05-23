public class Ride {
    public double distance;
    public int time;
    public PremiumRides cabRide;

    public Ride(double distance, int time, PremiumRides cabride) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabride;
    }
}
