package product_task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Category {
    private String category;
    private int sale;

    public Category(String category) {
        this.category = category;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getCategory() {
        return category;
    }
}

