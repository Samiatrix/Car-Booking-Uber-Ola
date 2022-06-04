package CabBooking.services.implementations;

import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.models.Rider;
import CabBooking.services.CabMatchingService;

import java.util.List;

public class CabMatchingServiceImpl implements CabMatchingService {
    @Override
    public Cab findOptimalCab(Rider rider, List<Cab> closeByCabs, Location fromPoint, Location endPoint) {
        return closeByCabs.get(0);
    }
}
