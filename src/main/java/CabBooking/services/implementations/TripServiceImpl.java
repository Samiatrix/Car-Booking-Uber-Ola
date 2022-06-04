package CabBooking.services.implementations;

import CabBooking.exceptions.CabNotFoundException;
import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.models.Rider;
import CabBooking.models.Trip;
import CabBooking.services.CabMatchingService;
import CabBooking.services.CabService;
import CabBooking.services.PricingService;
import CabBooking.services.TripService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripServiceImpl implements TripService {
    private CabService cabService;
    private CabMatchingService cabMatchingService;
    private PricingService pricingService;
    public Map<String, List<Trip>> trips = new HashMap<>();

    public TripServiceImpl(CabService cabService, CabMatchingService cabMatchingService, PricingService pricingService) {
        this.cabService = cabService;
        this.cabMatchingService = cabMatchingService;
        this.pricingService = pricingService;
    }

    private double MAX_DISTANCE_CAB_NEAR_FROMPOINT = 10.0;

    @Override
    public void bookRide(Rider rider, Location fromPoint, Location endPoint) {
        List<Cab> closeByCabs = cabService.getCabs(fromPoint, MAX_DISTANCE_CAB_NEAR_FROMPOINT);

        closeByCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());
        Cab bestCab = cabMatchingService.findOptimalCab(rider, closeByCabs, fromPoint, endPoint);
        if(bestCab == null){
            throw new CabNotFoundException();
        }
        Double price = pricingService.calculateFare(fromPoint, endPoint);

        Trip trip = new Trip(rider, bestCab, fromPoint, endPoint, price);
        if(!trips.containsKey(rider.getId())){
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(trip);
        bestCab.setCurrentTrip(trip);
    }

    @Override
    public void fetchHistory(Rider rider) {
        for(Trip trip : trips.get(rider.getId())){
            System.out.println(trip.getRider().getName() + " has booked a cab with ID: " + trip.getCab().getId() + " from " + trip.getFromPoint().toString() + " to " + trip.getEndPoint().toString() + " with price: " + trip.getPrice());
        }
    }

}
