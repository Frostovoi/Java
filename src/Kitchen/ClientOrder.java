package Kitchen;

import java.util.List;

public interface ClientOrder {

    void addMeal(Dish dish);

    List<String> getReceiptInfo();

}
