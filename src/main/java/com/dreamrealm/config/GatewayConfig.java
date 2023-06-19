package com.dreamrealm.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class GatewayConfig {
    @Bean
    @Profile("default")
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        System.out.println("test");
        return builder.routes()
                .route("message", r -> r.path("/api/message/**")
                        .uri("http://messages:8081"))
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("http://auth:8082"))
                .route("trading", r -> r.path("/api/trading/**")
                        .uri("http://trading:8083"))
                .route("readtrading", r -> r.path("/api/readtrading/**")
                        .uri("http://tradingtwo:8084"))
                .build();
    }

    @Bean
    @Profile("kubernetes")
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        System.out.println("kubernetes");
        return builder.routes()
                .route("message", r -> r.path("/api/message/**")
                        .uri("http://messages:8081"))
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("http://auth:8082"))
                .route("trading", r -> r.path("/api/trading/**")
                        .uri("http://trading:8083"))
                .route("readtrading", r -> r.path("/api/readtrading/**")
                        .uri("http://tradingtwo:8084"))
                .build();
    }

    @Bean
    @Profile("docker")
    public RouteLocator customRouteLocator3(RouteLocatorBuilder builder) {
        System.out.println("develop");
        return builder.routes()
                .route("message", r -> r.path("/api/message/**")
                        .uri("http://dreamrealm-messages:8081"))
                .route("auth", r -> r.path("/api/auth/**")
                        .uri("http://dreamrealm-auth:8082"))
                .route("trading", r -> r.path("/api/trading/**")
                        .uri("http://dreamrealm-trading:8083"))
                .route("readtrading", r -> r.path("/api/readtrading/**")
                        .uri("http://dreamrealm-tradingtwo:8084"))
                .build();
    }

}