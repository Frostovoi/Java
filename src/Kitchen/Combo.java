package Kitchen;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Combo extends Dish{
    private ArrayList<SimpleDish> dishes;


    public Combo(String name, BigDecimal cost, ArrayList<SimpleDish> dishes) {
        super(name, cost);
        this.dishes = dishes;
    }

    public ArrayList<SimpleDish> getDishes() {
        return dishes;
    }

    @Override
    public boolean isReady() {
        return dishes.stream().allMatch(SimpleDish::isReady);
    }
}
