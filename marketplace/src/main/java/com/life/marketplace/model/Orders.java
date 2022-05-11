package com.life.marketplace.model;

import java.util.ArrayList;

public class Orders {
    ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public ArrayList<Order> setOrders(ArrayList<Order> orders) {
        this.orders = orders;
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void removeOrder(Order order){orders.remove(order);}
}
