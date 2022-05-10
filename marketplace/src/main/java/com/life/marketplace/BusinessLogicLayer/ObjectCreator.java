package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.model.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectCreator {


    public static ArrayList<Products> createProductList(ResultSet rs) throws SQLException {
        ArrayList<Products> products = new ArrayList<>();

        while (rs.next()) {
            Products product = new Products();

            product.setId       (rs.getString(1));
            product.setPrice    (rs.getDouble(2));
            product.setDate     (rs.getDate  (3));
            product.setType     (rs.getString(4));
            product.setColor    (rs.getString(5));
            product.setCondition(rs.getString(6));
            product.setStatus   (rs.getString(7));
            product.setSeller   (rs.getString(8));
            product.setName     (rs.getString(9));

            products.add(product);
        }

        return products;
    }
}
