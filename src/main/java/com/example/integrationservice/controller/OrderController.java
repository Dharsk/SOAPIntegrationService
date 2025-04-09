package com.example.integrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrationservice.model.Order;
import com.example.integrationservice.model.OrderStatusRestResponse;
import com.example.integrationservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
    private OrderService orderService;

    @GetMapping("/orders/{id}/status")
    public ResponseEntity<Order> getOrderStatus(@PathVariable String id) {
        Order order = orderService.getOrderStatus(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    //Call from the soap to rest conversion api
    @PostMapping("/restapi/orderstatus")
    public ResponseEntity<Void> getOrderStatusCallFromSOAP(@RequestBody OrderStatusRestResponse orderStatusResponse) {
        
    	System.out.println("Rest call Order Status: " + orderStatusResponse.getStatus());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
 
}

