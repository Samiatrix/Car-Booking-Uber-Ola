package CabBooking.services;

import CabBooking.models.Location;
import CabBooking.models.Rider;

public interface TripService {

    void bookRide(Rider rider, Location fromPoint, Location endPoint);

    void fetchHistory(Rider rider);
}
