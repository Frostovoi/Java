package Delivery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Optional;

public class Repository {
    private ArrayList<Order> orders;
    private ArrayList<Courier> couriers;
    private Strategy curStrategy;

    public Repository(Strategy strategy) {
        this.curStrategy = strategy;
        this.orders = new ArrayList<>();
        this.couriers = new ArrayList<>();
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }


    public Order addOrder(double weight, GeoCoordinate departure, GeoCoordinate destination) {
        Order newOrder = new Order(departure,destination, weight, getId());
        orders.add(newOrder);
        return newOrder;
    }

    public boolean assignCourier(Order order) {
        Courier curCourier = curStrategy.select(order,couriers);

        if (curCourier != null) {
            order.setCourier(curCourier);
            curCourier.setCurOrder(order);
            order.setTimeStart(Calendar.getInstance());
            return true;
        }
        return false;
    }


    public void completeOrder(Order order) {
        order.setTimeEnd(Calendar.getInstance());
        order.getCourier().free();

    }


    public int getId() {
        Optional<Order> optID = orders.stream().max(Comparator.comparing(t->t.getId()));
        return optID.map(order -> order.getId() + 1).orElse(1);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Courier> getCouriers() {
        return couriers;
    }

    public Strategy getCurStrategy() {
        return curStrategy;
    }
}
