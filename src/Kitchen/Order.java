package Kitchen;

import java.util.*;
import java.util.stream.Collectors;

public class Order implements ClientOrder,KitchenOrder {
    private String orderNumber;
    private ArrayList<Dish> dishes;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        dishes = new ArrayList<>();
    }



    @Override
    public void addMeal(Dish dish) {
        dishes.add(dish);
    }

    @Override
    public List<String> getReceiptInfo() {
        return dishes.stream().
                map(t->t.getName() + " - " +  t.getCost().toString() + "R").
                collect(Collectors.toList());
    }

    @Override
    public void makeMealReady(String dishName) {
        getSimpleMeals().stream()
                .filter(t -> t.getName().equals(dishName) && !t.isReady()).findFirst()
                .ifPresent(SimpleDish::markAsReady);
        if (getSimpleMeals().stream().allMatch(SimpleDish::isReady))
            onOrderReady(orderNumber);
    }

    @Override
    public List<SimpleDish> getSimpleMeals() {
        ArrayList<SimpleDish> simpleMeals = new ArrayList<>();
        dishes.stream().filter(t->t instanceof Combo).map(t->((Combo) t).getDishes()).forEach(simpleMeals::addAll);
        dishes.stream().filter(t->!(t instanceof Combo)).forEach(t->simpleMeals.add((SimpleDish)t));
        return simpleMeals;
    }

    @Override
    public void onOrderReady(String orderNumber) {
        System.out.println("Order " + orderNumber + " is ready!");
    }
}

