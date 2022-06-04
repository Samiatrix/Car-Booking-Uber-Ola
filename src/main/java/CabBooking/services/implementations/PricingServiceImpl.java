package CabBooking.services.implementations;

import CabBooking.models.Location;
import CabBooking.services.PricingService;

public class PricingServiceImpl implements PricingService {
    private Double FARE_PER_KM = 5.00;
    @Override
    public Double calculateFare(Location fromPoint, Location endPoint) {
        return fromPoint.distance(endPoint) * FARE_PER_KM;
    }
}
