package CabBooking;

import CabBooking.controllers.CabController;
import CabBooking.controllers.RiderController;
import CabBooking.services.*;
import CabBooking.services.implementations.*;

public class CabBookingDriver {
    public static void main(String[] args) {
        CabService cabService = new CabServiceImpl();
        CabMatchingService cabMatchingService = new CabMatchingServiceImpl();
        PricingService pricingService = new PricingServiceImpl();
        RiderService riderService = new RiderServiceImpl();
        TripService tripService = new TripServiceImpl(cabService, cabMatchingService, pricingService);
        CabController cabController = new CabController(cabService, tripService);
        RiderController riderController = new RiderController(riderService, tripService);

        cabController.createCab("cabId1", "cabName1");
        cabController.createCab("cabId2", "cabName2");
        cabController.createCab("cabId3", "cabName3");
        cabController.createCab("cabId4", "cabName4");

        riderController.createRider("riderId1", "riderName1");
        riderController.createRider("riderId2", "riderName2");
        riderController.createRider("riderId3", "riderName3");
        riderController.createRider("riderId4", "riderName4");

        cabController.updateCabLocation("cabId1", 2, 3);
        cabController.updateCabLocation("cabId2", 4, 5);
        cabController.updateCabLocation("cabId3", 3, 4);
        cabController.updateCabLocation("cabId4", 5, 6);

        cabController.setAvailablility("cabId2", false);
        cabController.setAvailablility("cabId1", true);

        riderController.bookRide("riderId1", 2, 4, 5, 6);

        riderController.fetchHistory("riderId1");
        riderController.endTrip(cabService.getCab("cabId3"));



    }

}
