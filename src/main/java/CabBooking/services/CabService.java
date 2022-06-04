package CabBooking.services;

import CabBooking.models.Cab;
import CabBooking.models.Location;

import java.util.List;

public interface CabService {
    void createCab(Cab cab);

    void updateCabLocation(String cabId, Location location);

    void setAvailablity(String cabId, boolean availablity);

    List<Cab> getCabs(Location fromPoint, double max_distance_cab_near_frompoint);

    Cab getCab(String cabId);
}
