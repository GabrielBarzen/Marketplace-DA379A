package com.life.marketplace.DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;
import com.life.marketplace.model.Product;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.Properties;
import java.util.UUID;

public class DatabaseAccess {

    java.sql.Connection dbConnection;
    private String modelDbName = "dbadmin";
    private String modelDbPassword = "XEHjqXmGh2GYT2zfjJFkpQR8TQjjsk9aHPPiynUHYVqc5ycnf6jM5by2FFncgGY2Mr9UJvaQKFkxnhy8BUQ72ra3TCZmyYFV3mDoFuxLZC3zML6b6Cqp286wb5GmFupj";
    private String url = "jdbc:postgresql://gabnet.se:5432/marketplace_da397a";

    public DatabaseAccess() {

    }

    public java.sql.Connection getDbConnection() {
        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", modelDbName);
            connectionProps.put("password", modelDbPassword);
            dbConnection = DriverManager.getConnection(url, connectionProps);
            System.out.println("Connected yo");

        } catch (Exception e) {
            System.out.println("Något gick fel dude");
            e.printStackTrace();
        }

        return dbConnection;
    }

    public static void main(String[] args) {
        DatabaseAccess databaseAccess = new DatabaseAccess();

    }

    public ResultSet f_get_all_products() throws SQLException {
        String query = "SELECT * FROM f_get_all_products()";

        PreparedStatement statement = getDbConnection().prepareStatement(query);
        return statement.executeQuery();
    }



    public boolean f_add_to_cart(String username, UUID productID) {
        String query = String.format("SELECT * FROM f_add_to_cart(%s, %s)", username, productID);
        boolean success;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }

    public ResultSet f_login_user(String username, String password) {
        return null;
    }

    public ResultSet f_product_search(String type, String condition, double maxPrice, double minPrice) {
        return null;
    }

    public ResultSet f_register_user(String username, String email, String password, Date birthdate, String firstname, String lastname) {
        return null;
    }

    public ResultSet f_show_purchase_history(String username, Date startDate, Date endDate) {
        return null;
    }


    public ResultSet f_login_user(String username, String password) throws SQLException {
        String query = "SELECT f_login_user(?, ?);";
        PreparedStatement statement = dbConnection.prepareStatement(query);

        statement.setString(1, username);
        statement.setString(2, password);

        return statement.executeQuery();
    }
    
    /***********************************
     * PROCEDURES BELOW
     ***********************************/

    public boolean p_add_product(Double price, Date date, String type, String color, String condition, String sellerName, String productName) throws SQLException {
        boolean success;
        try {
            String query = "call p_add_product(?,?,?,?,?,?,?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setDouble(1, price);
            statement.setDate  (2, date);
            statement.setString(3, type);
            statement.setString(4, color);
            statement.setString(5, condition);
            statement.setString(6, sellerName);
            statement.setString(7, productName);
            statement.execute();
            success = true;
        }catch (SQLException e) {
            success = false;
        }
        return success;
    }


    public boolean p_add_subscription(String username, String type) throws SQLException {
        boolean success;
        try {
            String query = "CALL p_add_subscription(?,?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, type);
            statement.execute();
            success = true;
        }catch (SQLException e) {
            success = false;
        }
        return success;
    }

    //Tem-------------------------plate PLS NO USE MR GABIRELO 💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩
    public boolean p_create_order(String username) {
        boolean success;
        try {
            String query = "CALL p_create_order(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1,username);
            statement.execute();
            success = true;
        }catch (SQLException e) {
            success = false;
        }
        return success;
    }

    public boolean p_delete_user(String username) throws SQLException {
        boolean success;
        try {
            String query = "CALL p_delete_user(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1,username);
            statement.execute();
            success = true;
        }catch (SQLException e) {
            success = false;
        }
        return success;
    }

    public boolean p_remove_product(UUID uuid) {
        boolean success;
        try {
            String query = "CALL p_remove_product(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1,uuid.toString());
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }

    public boolean p_update_read_status(String username) {
        boolean success;
        try {
            String query = "CALL p_remove_product(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1,username);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
            return success;
    }

    public boolean p_user_place_order(UUID orderID) throws SQLException {
        boolean success;
        try {
            String query = "CALL p_user_place_order(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1, orderID.toString());
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }


    public boolean p_add_to_cart(String username, UUID productID) {
        boolean success;
        try {
            String query = "CALL p_add_to_cart(?,?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, productID.toString());
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }


}
