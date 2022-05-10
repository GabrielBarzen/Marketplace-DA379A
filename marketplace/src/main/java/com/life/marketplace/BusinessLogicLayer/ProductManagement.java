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

    public Types getTypes() {
        Types types = new Types();
        try {
            ResultSet rs = db.f_get_types();

            while(rs.next()) {


                types.addType(rs.getString(1));



            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return types;
    }

    public Colors getColors() {
        Colors colors = new Colors();
        try {
            ResultSet rs = db.f_get_colors();

            while(rs.next()) {


                colors.addColors(rs.getString(1));



            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return colors;
    }

    public Conditions getConditions() {
        Conditions conditions = new Conditions();
        try {
            ResultSet rs = db.f_get_colors();

            while(rs.next()) {


                conditions.addCondition(rs.getString(1));



            }
        } catch (SQLException e) {
            System.out.println("något gick fel");
        }
        return conditions;
    }

    public static void main(String[] args) {
        new ProductManagement();
    }
    public ProductManagement(){
        System.out.println(getProductSellLists());
    }
    
    public String getProductSellLists() {
        Gson gson = new Gson();

        String typeString = gson.toJson(getTypes());
        String conditionString = gson.toJson(getConditions());
        String colorString = gson.toJson(getColors());

        String str = "{"+ typeString +","+ conditionString +","+ colorString +"}";
        str = str.replaceAll("\\{", "");
        str = str.replaceAll("}", "");

        str = "{"+str+"}";

        return str;
    }

}
