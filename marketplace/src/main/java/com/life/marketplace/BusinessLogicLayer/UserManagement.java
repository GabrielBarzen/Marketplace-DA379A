package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.DataAccessLayer.DatabaseAccess;
import com.life.marketplace.model.Product;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserManagement {

    private DatabaseAccess db = new DatabaseAccess();

    public boolean loginUser(String username, String password) {
        boolean success = false;
        ResultSet rs;

        try {
            rs = db.f_login_user(username, password);

           while (rs.next()) {
               success = rs.getBoolean(1);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean registerUser(String username, String email, String password, Date birthdate, String firstname, String lastname) {
        boolean success = false;
        ResultSet rs;
        try {
            rs = db.f_register_user(username, email, password, birthdate, firstname, lastname);
            while (rs.next()) {
                success = rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();

    }

    public boolean updateReadStatus(String username) {
        return db.p_update_read_status(username);
    }

    public boolean deleteUser(String username) {
        return db.p_delete_user(username);
    }

    public boolean addSubscription(String username, String type) {
        return db.p_add_subscription(username, type);
    }

    public ArrayList<Product> showPurchaseHistory(String username, Date startDate, Date endDate) {
        ArrayList<Product> products = new ArrayList<>();

        try {

            products = ObjectCreator.createProductList(db.f_show_purchase_history(username, startDate, endDate));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return products;
    }



}
