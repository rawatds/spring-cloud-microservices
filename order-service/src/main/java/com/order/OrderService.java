package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    final String paymentUrl = "http://PAYMENT-SERVICE/payments";

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public Transaction saveOrderPayment(Transaction transaction) {

        Order order = transaction.getOrder();
        Payment payment = transaction.getPayment();

        order = repository.save(order);

        payment.setAmount(order.getAmount());
        payment.setOrderId(order.getId());
        payment.setPaymentStatus("success");

        payment = template.postForObject(paymentUrl, payment, Payment.class);

        return new Transaction(order, payment);

    }

    public Transaction getDummyOrderPayment() {

        Order order = new Order(100, "Keyboard", 10, 2000);
        //Payment payment = new Payment(200, "success", "111-ddd-eee-222", 100, 2000);

        Payment payment = template.getForObject(paymentUrl+"/1", Payment.class);

        return new Transaction(order, payment);

    }



    public List<Order> getAllOrders() {
        System.out.println("Retrieving all orders...");
        return repository.findAll();
    }

}
