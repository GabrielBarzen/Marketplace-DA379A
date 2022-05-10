package com.life.marketplace.data_access;

import com.life.marketplace.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public DatabaseAccess() {
        try {
            String url = "jdbc:postgresql://gabnet.se:5432/marketplace_da397a";
            java.sql.Connection conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", modelDbName);
            connectionProps.put("password", modelDbPassword);
            dbConnection = DriverManager.getConnection(url, connectionProps);
            System.out.println("Connected yo");
        } catch (Exception e) {
            System.out.println("Något gick fel dude");
        }
    }

    public static void main(String[] args) {
        DatabaseAccess databaseAccess = new DatabaseAccess();
        for (Product product : databaseAccess.f_get_all_products()) {
            System.out.println(product.getName());
            System.out.println(product.getId());
        }
    }

    public  ArrayList<Product> f_get_all_products() {

        ArrayList<Product> products = new ArrayList<>();

        String query = "SELECT * FROM f_get_all_products()";

        try {
            Product product = new Product();
            PreparedStatement statement = dbConnection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

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

    
    
    /***********************************
     * PROCEDURES BELOW
     ***********************************/


    public void p_add_subscription(String username, String type) {

        String query = "CALL p_add_subscription(" + username + ", " + type + ")";

        //PreparedStatement statement = dbConnection.prepareStatement(query);
    }

    public void p_create_order(String username) {

    }

    public void p_delete_user(String username) {
        String query = "CALL p_delete_user(" + username + ")";
        try {
            PreparedStatement statement = dbConnection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void p_remove_product(UUID uuid) {
        String query = String.format("CALL p_remove_product(%s)", uuid);
        try {
            PreparedStatement statement = dbConnection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    public void p_update_read_status(String username) {

    }

    public void p_user_place_order(UUID orderID) {

    }

    public void p_add_to_card(String username, UUID productID) {

    }


}
