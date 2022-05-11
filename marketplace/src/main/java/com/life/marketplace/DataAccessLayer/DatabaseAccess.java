package com.life.marketplace.DataAccessLayer;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.Properties;
import java.util.UUID;

public class DatabaseAccess {
    private String modelDbName = "dbadmin";
    private String modelDbPassword = "XEHjqXmGh2GYT2zfjJFkpQR8TQjjsk9aHPPiynUHYVqc5ycnf6jM5by2FFncgGY2Mr9UJvaQKFkxnhy8BUQ72ra3TCZmyYFV3mDoFuxLZC3zML6b6Cqp286wb5GmFupj";
    private String url = "jdbc:postgresql://10.0.0.1:5432/marketplace_da397a";


    public DatabaseAccess() {

    }

    public Connection getDbConnection() {
        Connection dbConnection = null;

        try {
            Properties connectionProps = new Properties();
            connectionProps.put("user", modelDbName);
            connectionProps.put("password", modelDbPassword);
            dbConnection = DriverManager.getConnection(url, connectionProps);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return dbConnection;
    }

    public ResultSet f_get_all_products() throws SQLException {
        String query = "SELECT * FROM f_get_all_products()";

        PreparedStatement statement = getDbConnection().prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet f_get_cart_for_user(String username) throws SQLException {
        String query = "select * from f_get_cart_for_user(?)";
        PreparedStatement statement = getDbConnection().prepareStatement(query);
        statement.setString(1, username);
        return statement.executeQuery();
    }

    public ResultSet f_product_search(String type, String condition, double maxPrice, double minPrice) throws SQLException {
        String query = "SELECT * FROM f_product_search(?,?,?,?);";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        statement.setString(1, type);
        statement.setString(2, condition);
        statement.setDouble(3, maxPrice);
        statement.setDouble(4, minPrice);

        return statement.executeQuery();
    }

    public ResultSet f_register_user(String username, String email, String password, Date birthdate, String firstname, String lastname) throws SQLException {
        String query = "SELECT * FROM f_register_user(?,?,?,?,?,?);";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        statement.setString(1, username);
        statement.setString(2, email);
        statement.setString(3, password);
        statement.setDate  (4, birthdate);
        statement.setString(5, firstname);
        statement.setString(6, lastname);

        return statement.executeQuery();
    }

    public ResultSet f_show_purchase_history(String username, Date startDate, Date endDate) throws SQLException {
        String query = "SELECT * FROM f_show_purchase_history(?,?,?);";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        statement.setString(1, username);
        statement.setDate  (2, startDate);
        statement.setDate  (3, endDate);


        return statement.executeQuery();
    }

    public ResultSet f_login_user(String username, String password) throws SQLException {
        String query = "SELECT f_login_user(?, ?);";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        statement.setString(1, username);
        statement.setString(2, password);

        return statement.executeQuery();
    }

    public ResultSet f_get_types() throws SQLException{
        String query = "select * from f_get_types();";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        return statement.executeQuery();
    }

    public ResultSet f_get_colors() throws SQLException{
        String query = "select * from f_get_colors();";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        return statement.executeQuery();
    }

    public ResultSet f_get_conditions() throws SQLException{
        String query = "select * from f_get_conditions();";

        PreparedStatement statement = getDbConnection().prepareStatement(query);

        return statement.executeQuery();
    }
    
    /***********************************
     * PROCEDURES BELOW
     ***********************************/

    public boolean p_add_product(Double price, Date date, String type, String color, String condition, String sellerName, String productName) {
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

    public boolean p_add_subscription(String username, String type) {
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

    public boolean p_delete_user(String username) {
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

    public boolean p_remove_product(UUID productID) {
        boolean success;
        try {
            String query = "CALL p_remove_product(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setObject(1, productID);
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

    public boolean p_user_place_order(UUID orderID) {
        boolean success;
        try {
            String query = "CALL p_user_place_order(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);
            statement.setObject(1, orderID);
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
            statement.setObject(2, productID);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }
    public boolean p_user_remove_cart(UUID orderID) {
        boolean success;
        try {
            String query = "CALL p_user_remove_cart(?)";
            PreparedStatement statement = getDbConnection().prepareStatement(query);

            statement.setObject(1, orderID);
            statement.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
        }
        return success;
    }


}
