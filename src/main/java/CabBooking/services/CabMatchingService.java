package CabBooking.services;

import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.models.Rider;

import java.util.List;

public interface CabMatchingService {
    Cab findOptimalCab(Rider rider, List<Cab> closeByCabs, Location fromPoint, Location endPoint);
}
