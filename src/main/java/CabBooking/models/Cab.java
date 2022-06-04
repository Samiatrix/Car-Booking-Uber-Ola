package CabBooking.models;

public class Cab {
    private String id;
    private String driverName;
    private boolean isAvailable;
    private Location currentLocation;
    private Trip currentTrip;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
        this.currentTrip = null;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
}
