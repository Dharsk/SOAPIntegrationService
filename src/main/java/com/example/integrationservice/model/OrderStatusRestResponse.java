package com.example.integrationservice.model;

public class OrderStatusRestResponse {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatusResponse{status='" + status + "'}";
    }
}