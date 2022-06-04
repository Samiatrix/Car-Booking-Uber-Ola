package CabBooking.models;

import static java.lang.Math.sqrt;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Location fromPoint){
        return sqrt(Math.pow((this.x-fromPoint.x), 2) + Math.pow((this.y- fromPoint.y), 2));
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
