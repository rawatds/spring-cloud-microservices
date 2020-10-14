package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }


    @PostMapping("/orders-payments")
    public Transaction addOrder(@RequestBody Transaction transaction) {
        return service.saveOrderPayment(transaction);
    }

    @GetMapping("/orders-payments")
    public Transaction addOrder() {
        return service.getDummyOrderPayment();
    }

    @GetMapping("/orders")
    public List<Order> showAllOrder() {
        return service.getAllOrders();
    }
}
