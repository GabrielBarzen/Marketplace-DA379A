package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectCreator {


    public static ArrayList<Product> createProductList(ResultSet rs) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();
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

    public Cart createCartList(ResultSet rs) throws SQLException {
        Cart cart = new Cart();

        while(rs.next()) {
            cart.setId(rs.getString(1));
            cart.setDate(rs.getDate(3));
            cart.setStatus(rs.getString(4));
            cart.setProduct(rs.getString(5));
            cart.setPrice(rs.getDouble(7));
            cart.setDateOfMake(rs.getDate(8));
            cart.setType(rs.getString(9));
            cart.setColor(rs.getString(10));
            cart.setCondition(rs.getString(11));
            cart.setProductStatus(rs.getString(12));
            cart.setSeller(rs.getString(13));
            cart.setName(rs.getString(14));
        }

        return cart;
    }

    public ArrayList<Offer> createOfferList(ResultSet rs) throws SQLException {
        ArrayList<Offer> offers = new ArrayList<>();
        Offer offer;

        while (rs.next()) {
            offer = new Offer();
            offer.setOrderID(rs.getString(1));
            offer.setProductID(rs.getString(2));
            offer.setProductName(rs.getString(3));
            offer.setPrice(rs.getDouble(4));
            offer.setStatus(rs.getString(5));
            offer.setBuyerUsername(rs.getString(6));

            offers.add(offer);
        }

        return offers;
    }
}
