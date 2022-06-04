package CabBooking.controllers;

import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.services.CabService;
import CabBooking.services.TripService;

public class CabController {
    private CabService cabService;
    private TripService tripService;

    public CabController(CabService cabService, TripService tripService) {
        this.cabService = cabService;
        this.tripService = tripService;
    }

    public void createCab(String cabId, String driverName){
        cabService.createCab(new Cab(cabId, driverName));
    }

    public void updateCabLocation(String cabId, int locationX, int locationY){
        cabService.updateCabLocation(cabId, new Location(locationX, locationY));
    }

    public void setAvailablility(String cabId, boolean availablity){
        cabService.setAvailablity(cabId, availablity);
    }

}
