package com.example.progetton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public ShippingService expressShippingService() {
        return new CustomExpressShippingService();
    }
}
