package Patterns.SmartParking;


import java.math.BigDecimal;

public class Tariff {
    private int minutes;
    private BigDecimal rate;

    public Tariff(int minutes, BigDecimal rate) {
        this.minutes = minutes;
        this.rate = rate;
    }

    public int getMinutes() {
        return minutes;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
