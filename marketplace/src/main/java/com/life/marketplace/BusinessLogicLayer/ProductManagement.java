package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.DataAccessLayer.DatabaseAccess;
import com.life.marketplace.model.Product;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class ProductManagement {

    DatabaseAccess db = new DatabaseAccess();

    public boolean addProduct(Double price, Date date, String type, String color, String condition, String sellerName, String productName) {
        return db.p_add_product(price, date, type, condition, color, sellerName, productName);
    }

    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> products = new ArrayList<>();

        try {

            products = ObjectCreator.createProductList(db.f_get_all_products());

        } catch (SQLException e) {
            System.out.println("Nä du det ballade ur");
            e.printStackTrace();
        }

        return products;
    }

    public boolean addToCart(String username, UUID productID) {
        return db.p_add_to_cart(username, productID);
    }

    public boolean placeOrder(UUID orderID) {
        return db.p_user_place_order(orderID);
    }

    public boolean removeProduct(UUID productID) {
        return db.p_remove_product(productID);
    }

    public ArrayList<Product> productSearch(String type, String condition, double maxPrice, double minPrice) {

        ArrayList<Product> products = new ArrayList<>();

        try {

            products = ObjectCreator.createProductList(db.f_product_search(type, condition, maxPrice, minPrice));

        } catch (SQLException e) {
            System.out.println("Nä du det ballade ur");
            e.printStackTrace();
        }

        return products;
    }



}
