package com.javafundamentalAssignment7.app;

import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ProductStreamFunctions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Enter the number of products:");
        int numOfProducts = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Category: ");
            String category = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            products.add(new Product(name, category, price, quantity));
        }

        List<String> topProducts = products.stream()
                .filter(product -> product.getQuantity() > 0)
                .sorted((a, b) -> Double.compare(b.getTotal(), a.getTotal())) 
                .limit(5)
                .map(Product::getName)
                .collect(Collectors.toList()); 

        System.out.println("Top 5 most expensive products:");
        System.out.println(topProducts);

        input.close();
    }
}
