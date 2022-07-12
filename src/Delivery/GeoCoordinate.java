package Delivery;

public class GeoCoordinate {
    private double latitude;
    private double longitude;

    public GeoCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistanceTo(GeoCoordinate coordinate) {
        return (Math.sqrt
                (Math.pow(this.latitude - coordinate.latitude, 2)
                        + Math.pow(this.longitude - coordinate.longitude, 2))
        );
    }
}
