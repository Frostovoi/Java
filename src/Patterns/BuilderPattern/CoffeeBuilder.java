package Patterns.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class CoffeeBuilder {
    private String sort;
    private List<Milk> milks;
    private List<Sugar> sugars;

    public CoffeeBuilder() {
        milks = new ArrayList<>();
        sugars = new ArrayList<>();
    }


    public CoffeeBuilder setBlackCoffee(){
        sort = "Black";
        return this;
    }

    public CoffeeBuilder setCubanoCoffee(){
        sort = "Cubano";
        withSugar("Brown");
        return this;
    }

    public CoffeeBuilder setAntoccinoCoffee(){
        sort = "Antoccino";
        withMilk(0.5);
        return this;
    }

    public CoffeeBuilder withMilk(double fat){
        milks.add(new Milk(fat));
        return this;
    }

    public CoffeeBuilder withSugar(String sort){
        sugars.add(new Sugar(sort));
        return this;
    }

    public Coffee build(){
        return new Coffee(sort, milks, sugars);
    }
}

//public class CoffeeBuilder {
//    private Coffee coffee;
//
//    public CoffeeBuilder() {
//       coffee = new Coffee();
//    }
//
//
//    public CoffeeBuilder setBlackCoffee(){
//        coffee.setSort("Black");
//        return this;
//    }
//
//    public CoffeeBuilder setCubanoCoffee(){
//        coffee.setSort("Cubano");
//        withSugar("Brown");
//        return this;
//    }
//
//    public CoffeeBuilder setAntoccinoCoffee(){
//        coffee.setSort("Americano");
//        withMilk(0.5);
//        return this;
//    }
//
//    public CoffeeBuilder withMilk(double fat){
//        coffee.addMilk(new Milk(fat));
//        return this;
//    }
//
//    public CoffeeBuilder withSugar(String sort){
//        coffee.addSugar(new Sugar(sort));
//        return this;
//    }
//
//    public Coffee build(){
//        return coffee;
//    }
//}
