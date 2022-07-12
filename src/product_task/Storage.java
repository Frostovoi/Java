package product_task;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.bethecoder.ascii_table.ASCIITable;


public class Storage {
    private ArrayList<Product> products = new ArrayList<>();
    private HashSet<Category> categories = new HashSet<>();

    public Storage() {
        readFile();
    }

    public void addProduct(Product product) {
        products.add(product);
        categories.add(product.getCategory());
        saveToFile();
    }

    public void removeProduct(int id){
        products.remove(findProduct(id));
        saveToFile();
    }

    public void removeProduct(String name){
        products.remove(findProduct(name));
        saveToFile();
    }

    public void saveToFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.dat"))){
            oos.writeObject(products);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //после загрузки актуализировать counter
    public void readFile() {
        if (new File("products.dat").exists()) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("products.dat"))) {
                products = (ArrayList<Product>) is.readObject();
                int lastId = products.get(products.size() - 1).getId();
                Product.setCounter(lastId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Product findProduct(String name) {
//        for (Product product : products){
//            if (product.getName().equals(name))
//                return product;
//        }
//        return null;
        Optional<Product> optionalProduct = products.stream().filter(t->t.getName().equals(name)).findFirst();
        return optionalProduct.orElse(null);
    }

    public void sortByName() {
        products = products.stream().sorted(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    public Product maxProduct() {
        Optional<Product> maxProduct = products.stream().max(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getCost(),o2.getCost());
            }
        });
        return maxProduct.orElse(null);
    }

    public int sumProducts() {
        return products.stream().reduce(0, (a,b) -> { return a + b.getCost() * b.getAmount(); }, Integer::sum);
    }

    public boolean productIsEmpty() {
        return products.stream().anyMatch(t->t.getAmount() == 0);
    }

    public ArrayList<Product> findCategory(String category){
        ArrayList<Product> productsCategory = new ArrayList<>();
        for (Product product : products){
            if (product.getCategory().equals(category))
                productsCategory.add(product);
        }
        return productsCategory;
    }


    public Product findProduct(int id){
        for (Product product : products){
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    public void showTable(){
        String[] tableHeader = {"id", "Наименование", "Количество", "Стоимость", "Категория","Скидка"};
        String[][] tableData = new String[products.size()][6];
        for (int i = 0; i < products.size(); i++){
            tableData[i][0] = String.valueOf(products.get(i).getId());
        }
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProduct(int index) {
        return products.get(index);
    }


    public int getCountProducts() {
        return products.size();
    }

    public HashSet<Category> getCategories() {
        return categories;
    }
}
