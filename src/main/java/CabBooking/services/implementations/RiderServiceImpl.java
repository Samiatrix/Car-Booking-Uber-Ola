package CabBooking.services.implementations;

import CabBooking.exceptions.RiderAlreadyPresentException;
import CabBooking.exceptions.RiderNotFoundException;
import CabBooking.models.Rider;
import CabBooking.services.RiderService;

import java.util.HashMap;
import java.util.Map;

public class RiderServiceImpl implements RiderService {
    Map<String, Rider> riders;

    public RiderServiceImpl() {
        this.riders = new HashMap<>();
    }

    @Override
    public void createRider(Rider rider) {
        if(riders.containsKey(rider.getId())){
            throw new RiderAlreadyPresentException();
        }
        riders.put(rider.getId(), rider);
    }

    @Override
    public Rider getRider(String riderId) {
        if(!riders.containsKey(riderId)){
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}
