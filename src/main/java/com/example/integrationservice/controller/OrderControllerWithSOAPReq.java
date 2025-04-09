package com.example.integrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrationservice.model.Order;
import com.example.integrationservice.service.OrderService;

@RestController
@RequestMapping("/orders/soap")
public class OrderControllerWithSOAPReq {

	@Autowired
    private OrderService orderService;

    @GetMapping("/{id}/status")
    public ResponseEntity<Order> getOrderStatus(@PathVariable String id) {
        Order order = orderService.getOrderStatususingSOAPRequest(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}