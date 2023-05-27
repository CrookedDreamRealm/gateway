package com.dreamrealm.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("http://dreamrealm-auth:8082"))
                .route("messages", r -> r.path("/api/message/**")
                        .uri("http://dreamrealm-messages:8081"))
                .route("trading", r -> r.path("/api/trading/**")
                        .uri("http://dreamrealm-trading:8083"))
                .build();
    }
}