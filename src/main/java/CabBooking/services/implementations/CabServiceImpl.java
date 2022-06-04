package CabBooking.services.implementations;

import CabBooking.exceptions.CabAlreadyPresent;
import CabBooking.exceptions.CabNotFoundException;
import CabBooking.models.Cab;
import CabBooking.models.Location;
import CabBooking.services.CabService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabServiceImpl implements CabService {
    Map<String, Cab> cabs;

    public CabServiceImpl() {
        this.cabs = new HashMap<>();
    }

    @Override
    public void createCab(Cab cab) {
        if(cabs.containsKey(cab.getId())){
            throw new CabAlreadyPresent();
        }
        cabs.put(cab.getId(), cab);
    }

    @Override
    public void updateCabLocation(String cabId, Location location) {
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setCurrentLocation(location);
    }

    @Override
    public void setAvailablity(String cabId, boolean availablity) {
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setAvailable(availablity);
    }

    @Override
    public List<Cab> getCabs(Location fromPoint, double max_distance_cab_near_frompoint) {
        List<Cab> closeByCabs = new ArrayList<>();
        for(Cab cab : cabs.values()){
            if(cab.isAvailable() && cab.getCurrentLocation().distance(fromPoint) <= max_distance_cab_near_frompoint){
                closeByCabs.add(cab);
            }
        }
        return closeByCabs;
    }

    @Override
    public Cab getCab(String cabId) {
        return cabs.get(cabId);
    }
}
