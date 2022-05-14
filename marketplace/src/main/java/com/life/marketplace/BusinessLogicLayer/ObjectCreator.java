package com.life.marketplace.BusinessLogicLayer;

import com.life.marketplace.model.*;
import com.life.marketplace.model.OrderAndProduct;
import com.life.marketplace.model.Product;
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
  
  
    public OrderAndProduct createCartList(ResultSet rs) throws SQLException {


        OrderAndProduct orderAndProduct = new OrderAndProduct();
        while(rs.next()) {

            orderAndProduct.setId(rs.getString(1));
            orderAndProduct.setDate(rs.getDate(3));
            orderAndProduct.setStatus(rs.getString(4));
            orderAndProduct.setProduct(rs.getString(5));
            orderAndProduct.setPrice(rs.getDouble(7));
            orderAndProduct.setDateOfMake(rs.getDate(8));
            orderAndProduct.setType(rs.getString(9));
            orderAndProduct.setColor(rs.getString(10));
            orderAndProduct.setCondition(rs.getString(11));
            orderAndProduct.setProductStatus(rs.getString(12));
            orderAndProduct.setSeller(rs.getString(13));
            orderAndProduct.setName(rs.getString(14));

        }
        return orderAndProduct;
    }

    public ArrayList<OrderAndProduct> createPurchaseHistoryList(ResultSet rs) throws SQLException {
        ArrayList<OrderAndProduct> ordersAndProducts = new ArrayList<>();
        while(rs.next()) {
            System.out.println(rs.toString());
            OrderAndProduct orderAndProduct = new OrderAndProduct();
            orderAndProduct.setDate(rs.getDate(2));
            orderAndProduct.setId(rs.getString(3));
            orderAndProduct.setProduct(rs.getString(4));
            orderAndProduct.setName(rs.getString(5));
            orderAndProduct.setPrice(rs.getDouble(6));
            orderAndProduct.setDateOfMake(rs.getDate(7));
            orderAndProduct.setType(rs.getString(8));
            orderAndProduct.setColor(rs.getString(9));
            orderAndProduct.setCondition(rs.getString(10));
            orderAndProduct.setProductStatus(rs.getString(11));
            orderAndProduct.setSeller(rs.getString(12));
            orderAndProduct.setStatus(rs.getString(13));
            ordersAndProducts.add(orderAndProduct);
        }
        return ordersAndProducts;
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
