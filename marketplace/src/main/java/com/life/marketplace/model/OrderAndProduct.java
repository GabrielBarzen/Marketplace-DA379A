package com.life.marketplace.model;

import java.sql.Date;

public class OrderAndProduct {
    private String id;
    private java.sql.Date date;
    private String status;
    private String product;
    private double price;
    private java.sql.Date dateOfMake;
    private String type;
    private String color;
    private String condition;
    private String productStatus;
    private String seller;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfMake() {
        return dateOfMake;
    }

    public void setDateOfMake(Date dateOfMake) {
        this.dateOfMake = dateOfMake;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
