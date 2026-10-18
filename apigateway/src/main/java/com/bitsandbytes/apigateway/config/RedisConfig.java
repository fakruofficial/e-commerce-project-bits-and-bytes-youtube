package com.bitsandbytes.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RedisConfig {

    @Bean
    public KeyResolver ipKeyResolver(){
        return exchange -> {
            String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            return Mono.just(ip);
        };
    }
}





//
//
//The flow is:
//        1. First request: Redis doesn't have the product, so Spring Boot fetches it from the database and saves a copy in Redis.
//        2. Second request: Redis already has the product, so Spring Boot returns it without querying the database.
//3. More requests: Spring Boot can keep returning the cached copy until it expires or gets updated.