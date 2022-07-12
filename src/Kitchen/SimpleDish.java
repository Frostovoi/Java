package Kitchen;

import java.math.BigDecimal;

public class SimpleDish extends Dish {
    private boolean isReady;

    public SimpleDish(String name, BigDecimal cost) {
        super(name, cost);
    }

    public boolean isReady() {
        return isReady;
    }

    protected void markAsReady() {
        isReady = true;
    }
}
