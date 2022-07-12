package Patterns.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String sort;
    private List<Milk> milks;
    private List<Sugar> sugars;

    public Coffee(String sort, List<Milk> milks, List<Sugar> sugars) {
        this.sort = sort;
        this.milks = milks;
        this.sugars = sugars;
    }

    public Coffee(String sort) {
        this.sort = sort;
        milks = new ArrayList<>();
        sugars = new ArrayList<>();
    }

    public Coffee() {
        milks = new ArrayList<>();
        sugars = new ArrayList<>();
    }

    public void addMilk(Milk milk) {
        milks.add(milk);
    }

    public void addSugar(Sugar sugar) {
        sugars.add(sugar);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
