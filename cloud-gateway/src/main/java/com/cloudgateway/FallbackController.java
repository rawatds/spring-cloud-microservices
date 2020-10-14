package com.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback() {
        return Mono.just("The ORDER-SERVICE seems to be down. Please try later.");
    }

    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("The PAYNMENT-SERVICE seems to be down. Please try later.");
    }

}

