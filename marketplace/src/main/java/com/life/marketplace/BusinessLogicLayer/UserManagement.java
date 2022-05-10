package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.DataAccessLayer.DatabaseAccess;
import com.life.marketplace.model.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {

    public DatabaseAccess db = new DatabaseAccess();
    public boolean loginUser(String username, String password) {

        DatabaseAccess db = new DatabaseAccess();
        String response = "kaozzzz";
        boolean success = false;
        ResultSet rs = null;

        try {
            rs = db.f_login_user(username, password);

            if (rs.next()) {
                response = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (response != null && response.equals(username)) {
            success = true;
        }

        return success;
    }

    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> products = new ArrayList<>();

        try {
            Product product = new Product();

            ResultSet rs = db.f_get_all_products();

            while (rs.next()) {
                product.setId(rs.getString(1));
                product.setPrice(Double.parseDouble(rs.getString(2)));
                product.setDate(rs.getDate(3));
                product.setType(rs.getString(4));
                product.setColor(rs.getString(5));
                product.setCondition(rs.getString(6));
                product.setStatus(rs.getString(7));
                product.setSeller(rs.getString(8));
                product.setName(rs.getString(9));

                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Nä du det ballade ur");
            e.printStackTrace();
        }

        return products;
    }

    public boolean addProduct(Double price, Date date, String type, String color, String condition, String sellerName, String productName) {

        try {
            db.p_add_product(price, date, type, condition, color, sellerName, productName);
        } catch (SQLException e) {
            System.out.println("MAMMM VA FRETT");
        }

        return false;
    }
}
