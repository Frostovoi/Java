package Delivery;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinimalOrdersStrategy implements Strategy {

    @Override
    public Courier select(Order order, List<Courier> couriers) {
        Optional<Courier> courier=
                couriers.stream().
                        filter(t->t.isAvailable() &&
                        t.getMaxWeight() >= order.getWeight()).
                        min(Comparator.comparing(Courier::amountOrdersForDay
                        ));
        return courier.orElse(null);
    }
}
