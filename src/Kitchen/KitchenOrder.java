package Kitchen;

import java.util.List;

public interface KitchenOrder {

    void makeMealReady(String dishName);

    List<SimpleDish> getSimpleMeals();

    void onOrderReady(String arg);
}
