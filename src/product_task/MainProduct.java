package product_task;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainProduct {


    static Product create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название: ");
        String name = scanner.nextLine();

        System.out.println("Введите стоимость: ");
        int cost = scanner.nextInt();

        System.out.println("Введите кол-во: ");
        int count = scanner.nextInt();

        System.out.println("Введите название категории, к которой принадлежит продукт: ");
        scanner.nextLine();
        String category = scanner.nextLine();

        return new Product(name, count, cost, new Category(category));
    }

    private static void newName(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое название товара");
        String newName = scanner.nextLine();
        product.setName(newName);
    }

    private static void newCost(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новую цену товара");
        int newCost = scanner.nextInt();
        product.setCost(newCost);
    }

    private static void newAmount(Product product) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое количество товара");
        int newAmount = scanner.nextInt();
        product.setAmount(newAmount);
    }

    private static void newCategory(Product product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новое название категории для данного товара");
        String newCategory = scanner.nextLine();
        product.setCategory(newCategory);
    }

    static void editProduct(Product product) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1.Редактировать название");
            System.out.println("2.Редактировать цену");
            System.out.println("3.Редактировать количество");
            System.out.println("4.Редактировать категорию");
            System.out.println("5.Редактировать всё");
            System.out.println("6.Закончить редактирование");

            int action = scanner.nextInt();

            switch (action) {
                case 6: {
                    return;
                }
                case 1: {
                    newName(product);

                }
                case 2: {
                    newCost(product);
                    break;
                }
                case 3: {
                    newAmount(product);
                    break;
                }
                case 4: {
                    newCategory(product);
                    break;
                }
                case 5: {
                    newName(product);
                    newCost(product);
                    newAmount(product);
                    break;
                }
            }
        }
        while (true);
    }


    static HashMap<Category, Integer> getAllCategories(ArrayList<Product> products) {
        HashMap<Category, Integer> mapCategories = new HashMap<>();
        for (Product product : products) {
            Category curCategory = product.getCategory();
            mapCategories.put(
                    curCategory, mapCategories.getOrDefault(curCategory, 0) + product.getAmount()
            );
        }
        return mapCategories;
    }

    static void printCategories(ArrayList<Product> products) {
        HashMap<Category, Integer> categories = getAllCategories(products);
        for (var category : categories.entrySet()) {
            System.out.println(category.getKey() + "\t" + category.getValue());
        }
    }

    static void saleForCategory(Storage storage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите категорию, которой хотите установить скидку:");
        String categoryForSale = scanner.nextLine();
        System.out.println("Введите размер скидки, которую хотите задать указанной категории: ");

        int sale = scanner.nextInt();
        Category category = new Category(categoryForSale);
        category.setSale(sale);
        var categories = storage.getCategories();
        categories.add(category);



    }

    static HashMap<String, Integer> enough(ArrayList<Product> products) {
        HashMap<String, Integer> enoughProduct = new HashMap<>();
        for (Product product : products) {
            Scanner scanner = new Scanner(System.in);
            String curProduct = product.getName();
            System.out.println("Для продукта " + curProduct + " введите достаточное количество: ");
            int enough = scanner.nextInt();
            enoughProduct.put(curProduct, enough);
        }
        return enoughProduct;
    }

    static void endingProducts(ArrayList<Product> products) {
        HashMap<String, Integer> enough = enough(products);
        for (Product product : products) {
            String curProduct = product.getName();
            if (product.getAmount() < enough.get(curProduct))
                System.out.println(curProduct + " заканчивается");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();

        do {
            System.out.println();
            System.out.println("1.Создать продукт");
            System.out.println("2.Вывод продуктов");
            System.out.println("3.Редактировать продукт");
            System.out.println("4.Удалить продукт");
            System.out.println("5.Вывести на экран категории товаров и кол-во товаров");
            System.out.println("6.Вывести товары которые заканчиваются");
            System.out.println("7.Задать скидку указанной категории");

            int action = scanner.nextInt();

            switch (action) {
                case 1: {
                    Product product = create();
                    storage.addProduct(product);
                    break;
                }
                case 2: {
                    //showTable(storage);
                    break;
                }
                case 3: {
                    int id = 2;
                    Product product = storage.findProduct(id);
                    editProduct(product);
                    storage.saveToFile();
                    break;
                }
                case 4: {
                    int id = 2;
                    storage.removeProduct(id);
                    break;
                }
                case 5: {
                    printCategories(storage.getProducts());
                    break;
                }
                case 6: {
                    endingProducts(storage.getProducts());
                    break;
                }
                case 7: {
                    saleForCategory(storage);
                    break;
                }

            }
        }
        while (true);
    }
}

//добавить в класс продукт категорию и скидку
//добавить пункт меню задать скидку заданной категории товаров
//