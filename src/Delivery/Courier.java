package Delivery;

import com.google.api.services.coordinate.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Courier {
    private String name;
    private String phone;
    private double maxWeight;
    private GeoCoordinate curPosition;
    private ArrayList<Order> orders;
    private Order curOrder;



    public Courier(String name, String phone, double maxWeight) {
        this.name = name;
        this.phone = phone;
        this.maxWeight = maxWeight;
    }

    public boolean isAvailable (){return curOrder == null;}


    public GeoCoordinate getCurPosition() {
        return curPosition;
    }

    public void addOrder(Order order) {
        curOrder = order;
        orders.add(order);
    }

    public void setCurPosition(GeoCoordinate curPosition) {
        this.curPosition = curPosition;
    }

    public int amountOrdersForDay() {
        Calendar curDate = Calendar.getInstance();
        curDate.set(Calendar.HOUR_OF_DAY,0);
        curDate.set(Calendar.MINUTE,0);
        curDate.set(Calendar.SECOND,0);
        return (int) orders.stream().filter(t->t.getTimeStart().after(curDate)).count();
    }

    public void free() {
        curOrder = null;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setCurOrder(Order curOrder) {
        this.curOrder = curOrder;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order getCurOrder() {
        return curOrder;
    }
}
