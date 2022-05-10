package com.life.marketplace.BusinessLogicLayer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.life.marketplace.DataAccessLayer.DatabaseAccess;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import com.life.marketplace.model.*;

public class ProductManagement {

    DatabaseAccess db = new DatabaseAccess();

    public boolean addProduct(Double price, Date date, String type, String color, String condition, String sellerName, String productName) {
        return db.p_add_product(price, date, type, condition, color, sellerName, productName);
    }

    public ArrayList<Products> getAllProducts() {

        ArrayList<Products> products = new ArrayList<>();

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

    public ArrayList<Products> productSearch(String type, String condition, double maxPrice, double minPrice) {

        ArrayList<Products> products = new ArrayList<>();

        try {

            products = ObjectCreator.createProductList(db.f_product_search(type, condition, maxPrice, minPrice));

        } catch (SQLException e) {
            System.out.println("Nä du det ballade ur");
            e.printStackTrace();
        }

        return products;
    }

    public ArrayList<Types> getTypes() {
        ArrayList<Types> types = new ArrayList<>();

        try {
            ResultSet rs = db.f_get_types();

            while(rs.next()) {
                Types type = new Types();

                type.setType(rs.getString(1));

                types.add(type);

            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return types;
    }

    public ArrayList<Colors> getColors() {
        ArrayList<Colors> colors = new ArrayList<>();
        try {
            ResultSet rs = db.f_get_colors();

            while(rs.next()) {
                Colors color = new Colors();

                color.setColor(rs.getString(1));

                colors.add(color);

            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return colors;
    }

    public ArrayList<Conditions> getConditions() {
        ArrayList<Conditions> conditions = new ArrayList<>();
        try {
            ResultSet rs = db.f_get_colors();

            while(rs.next()) {
                Conditions condition = new Conditions();

                condition.setCondition(rs.getString(1));

                conditions.add(condition);

            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return conditions;
    }

    
    public String getProductSellLists() {
        Gson gson = new Gson();
        
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("Types", gson.toJson(getTypes()));
        jsonObject.addProperty("Conditions", gson.toJson(getConditions()));
        jsonObject.addProperty("Color", gson.toJson(getColors()));

        String str = gson.toJson(jsonObject);
        return str;
    }

}
