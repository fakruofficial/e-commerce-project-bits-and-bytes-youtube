package com.ecom.order_service.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced   // @LoadBalanced is used when you want Spring to call another microservice by its service name, instead of using localhost:port. - "http://product-service/products/
    public RestTemplate restTemplate(RestTemplateBuilder builder ) {
        return builder.build();
    }
}

//
//@LoadBalanced lets you call a service by its name instead of localhost:port.
//
//        Example:
//
//@LoadBalanced
//RestTemplate restTemplate;
//
//Then:
//
//        restTemplate.getForObject(
//    "http://product-service/products/1",
//    Product.class
//);
//
//Here, product-service is the service name, and LoadBalancer finds the available Product Service instance.