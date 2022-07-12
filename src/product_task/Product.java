package product_task;

import java.io.Serializable;
import java.util.Set;

public class Product implements Serializable {
    private String name;
    private Category category;
    private int sale;
    private int amount;
    private int cost;
    private int id;
    private static int counter = 1;


    public Product(String name, int amount, int cost, Category category) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.category = category;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public static void setCounter(int value) {
        counter = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = new Category(category);
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
        cost *= (double) (100 - sale) / 100;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", sale=" + sale +
                ", amount=" + amount +
                ", cost=" + cost +
                ", id=" + id +
                '}';
    }
}
