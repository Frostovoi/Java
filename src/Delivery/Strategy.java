package Delivery;

import java.util.ArrayList;
import java.util.List;

public interface Strategy {

    public Courier select(Order order, List<Courier> couriers);
}
