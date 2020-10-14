# Spring cloud microservices

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg)](https://github.com/rawatds/spring-cloud-microservices)

This repository is a collection of various microservices and other servers used with microservice architecture, e.g. registry-server, cloud-gateway, config-server, etc .

These microservices are developed in Java 8, SpringBoot 2.3.4.RELEASE, H2 in-memory database and latest Spring cloud version as of Oct 2020.Each folder has a specific microservice or a server and each has to run individually. We can write a script to run all servers in just one command.


## Main components/services
_(written in the order of their execution)_

  - **service-registry:** This is a Eureka service registry to register all services, their host, ports, etc. Its running on port 8761.
  - **cloud-gateway:** All user calls will come to this cloud gateway and bases on the url requested, it will forward the request to the corresponding microservice for processing. Its running on port 9000.
  - **order-service:** This is a sample order microservice. All the url patterns for this service starts with ```/orders``` string. Its running on port 9001.
  - **payment-service:** This is a sample payment microservice. All the url patterns for this service starts with ```/payments``` string. Its running on port 9002.
  - **hystrix-dashboard:** Its an optional service and used to trace fallbacks due to unavailablity of any microservices. So, basically its used to check how many failure are there if a microservice is down or unavailable. Its running on port 9100.

Also:
  - There is a CircuitBreaker functionality also implemented. So, if any on the order-service or payment-service is down, it will show proper error message to the user instead of generic 5xx error codes and non-user friendly messages.

### How To test
Run all the servers int the order specified above.

1. To add an order
```
curl --location --request POST 'http://localhost:9000/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "Jeyboard",
    "qty": 1,
    "amount": 1500
}'
```


2. To add a new order-payment
```
curl --location --request POST 'http://localhost:9000/orders-payments' \
--header 'Content-Type: application/json' \
--data-raw '{   "order" : {
                "name" : "Mouse",
                "qty": 2,
                "amount": 1500
            },
    "payment": {}
}'
```

3. To view a dummy order-payment data
```
curl --location --request GET 'http://localhost:9000/orders-payments' 
```

**Note:**
The ```/orders-payments/``` url calls the order-service and the order-service calls the payment-service. (inter-service communication)
### Thanks

 - I thank to the various youtube video tutorials creators who helped me a lot in learn Spring Cloud microservices.
 
License
----
**Free for everyone!**

