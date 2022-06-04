package CabBooking.controllers;

import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.models.Rider;
import CabBooking.services.RiderService;
import CabBooking.services.TripService;

public class RiderController {
    private RiderService riderService;
    private TripService tripService;

    public RiderController(RiderService riderService, TripService tripService) {
        this.riderService = riderService;
        this.tripService = tripService;
    }

    public void createRider(String id, String name){
        riderService.createRider(new Rider(id, name));
    }

    public void bookRide(String riderId, int riderX, int riderY, int tripX, int tripY){
        tripService.bookRide(riderService.getRider(riderId), new Location(riderX, riderY), new Location(tripX, tripY));
    }

    public void fetchHistory(String riderId){
        tripService.fetchHistory(riderService.getRider(riderId));
    }

    public void endTrip(Cab cab){
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
