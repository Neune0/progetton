package com.example.progetton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.progetton.ShippingService;
import com.example.progetton.StandardShippingService;

@Configuration
public class AppConfig {
    @Bean(name = "expressShippingService")
    public ShippingService expressShippingService() {
        return new CustomExpressShippingService();
    }
}
