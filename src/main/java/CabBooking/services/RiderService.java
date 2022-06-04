package CabBooking.services;

import CabBooking.models.Location;
import CabBooking.models.Rider;

public interface RiderService {
    void createRider(Rider rider);

    Rider getRider(String riderId);
}
