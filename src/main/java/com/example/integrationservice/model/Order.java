package com.example.integrationservice.model;

public class Order {
    private String orderID;
    private String status;

    public Order(String id, String status) {
        this.orderID = id;
        this.status = status;
    }

    public String getId() { return orderID; }
    public String getStatus() { return status; }
}