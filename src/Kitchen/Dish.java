package Kitchen;

import java.math.BigDecimal;

public abstract class Dish {
    private String name;
    private BigDecimal cost;

    public Dish(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public abstract boolean isReady();
}
