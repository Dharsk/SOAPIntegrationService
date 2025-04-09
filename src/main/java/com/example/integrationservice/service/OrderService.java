package com.example.integrationservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrationservice.model.Order;
import com.example.integrationservice.soapclient.OrderstatusClient;
import com.test.integrationservice.wsdl.OrderStatusResponse;

@Service
public class OrderService {
	
	@Autowired
	OrderstatusClient orderStatusClient;
	
    private final Map<String, Order> orders = new HashMap<>();

	
	 public OrderService() {
	        // Initialize with some sample data
	        orders.put("001", new Order("001", "PENDING"));
	        orders.put("002", new Order("002", "SHIPPED"));
	    }
	 
	public Order getOrderStatus(String orderId) {
		
        return orders.get(orderId);

    }

	public Order getOrderStatususingSOAPRequest(String orderID) {
		
		OrderStatusResponse response = orderStatusClient.getStatus(orderID);
		if (response != null) {
			return new Order(orderID,response.getStatus());
        } else {
            return null;  // TBU
        }
		
	}

}
