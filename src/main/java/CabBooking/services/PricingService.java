package CabBooking.services;

import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.models.Rider;

import java.util.List;

public interface PricingService {

    Double calculateFare(Location fromPoint, Location endPoint);
}
