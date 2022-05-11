package com.life.marketplace.model;

import java.util.ArrayList;

public class Products {

    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Product> setProducts(ArrayList<Product> products) {
        this.products = products;
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product){products.remove(product);}
}
