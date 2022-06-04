package CabBooking.models;

import static CabBooking.models.TripStatus.COMPLETED;
import static CabBooking.models.TripStatus.IN_PROGRESS;

enum TripStatus{
    IN_PROGRESS,
    COMPLETED
}
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Location fromPoint;
    private Location endPoint;
    private Double price;

    public Trip(Rider rider, Cab cab, Location fromPoint, Location endPoint, Double price) {
        this.rider = rider;
        this.cab = cab;
        this.tripStatus = IN_PROGRESS;
        this.fromPoint = fromPoint;
        this.endPoint = endPoint;
        this.price = price;
    }

    public void endTrip(){
        this.tripStatus = COMPLETED;
    }

    public Rider getRider() {
        return rider;
    }

    public Cab getCab() {
        return cab;
    }

    public Location getFromPoint() {
        return fromPoint;
    }

    public Location getEndPoint() {
        return endPoint;
    }

    public Double getPrice() {
        return price;
    }
}
