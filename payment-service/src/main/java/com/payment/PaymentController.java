package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping("/payments")
    public Payment addPayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return service.retrieveAllPayments();
    }

    @GetMapping("/payments/1")
    public Payment getOnePayments() {
        return new Payment(100, "success", "aa-bb-cc", 100, 2000);
    }
}
