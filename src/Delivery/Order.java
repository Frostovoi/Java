package Delivery;

import com.google.api.services.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private Calendar timeStart;
    private Calendar timeEnd;
    private GeoCoordinate departure;
    private GeoCoordinate destination;
    private int id;
    private double weight;
    private Courier courier;


    public Order(GeoCoordinate departure, GeoCoordinate destination, double weight, int id) {
        this.departure = departure;
        this.destination = destination;
        this.id = id;
        this.weight = weight;
    }

    public GeoCoordinate getDeparture() {
        return departure;
    }

    public GeoCoordinate getDestination() {
        return destination;
    }

    public int getId() {
        return id;
    }

    public Calendar getTimeStart() {
        return timeStart;
    }

    public Calendar getTimeEnd() {
        return timeEnd;
    }

    public double getWeight() {
        return weight;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setTimeStart(Calendar timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Calendar timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setDeparture(GeoCoordinate departure) {
        this.departure = departure;
    }

    public void setDestination(GeoCoordinate destination) {
        this.destination = destination;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
