package InterfaceTasks;

public class Car implements Comparable<Car> {
    private String model;
    private int cost;

    public Car(String model, int cost) {
        this.model = model;
        this.cost = cost;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Car o) {
//        if (cost > o.cost)
//            return 1;
//        else if (cost < o.cost)
//            return -1;
//        return 0;

        //return Integer.compare(cost, o.cost);

        return model.compareTo(o.model);
    }
}
