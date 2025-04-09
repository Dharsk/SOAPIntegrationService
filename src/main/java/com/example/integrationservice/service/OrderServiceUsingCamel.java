package com.example.integrationservice.service;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrationservice.model.Order;
import com.test.integrationservice.wsdl.OrderStatusRequest;
import com.test.integrationservice.wsdl.OrderStatusResponse;

@Service
public class OrderServiceUsingCamel {
	 @Autowired
	    private ProducerTemplate producerTemplate;

	    public Order getOrderStatus(String orderId) {
	    	
	    	OrderStatusRequest orderRequest = new OrderStatusRequest();
	        orderRequest.setOrderId(orderId);
	        // Send a message to the Camel route (direct endpoint) and get the response
	        Object response = producerTemplate.requestBody("direct:getOrderStatus", orderRequest);
	        if (response instanceof OrderStatusResponse) {

	        	OrderStatusResponse orderResponse = (OrderStatusResponse) response;
	            return new Order(orderId, orderResponse.getStatus());
	        } else {
	            return null;  
	        }
	    }
}
