package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repo;


    public Payment savePayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        return repo.save(payment);
    }

    public List<Payment> retrieveAllPayments() {
        System.out.println("Retrieving all payments...");
        return repo.findAll();
    }
}
