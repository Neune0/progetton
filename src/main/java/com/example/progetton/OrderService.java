package com.example.progetton;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OrderService {
    private final ShippingService standardShippingService;
    private final ShippingService expressShippingService;

    public OrderService(@Qualifier ("standardShippingService") ShippingService standardShippingService,
                        @Qualifier ("expressShippingService") ShippingService expressShippingService) {
        this.standardShippingService = standardShippingService;
        this.expressShippingService = expressShippingService;
    }

    public double getTotalShipping(String shippingType, String country, double weight){
        if (shippingType.equalsIgnoreCase("standard")){
            return standardShippingService.calculateShipping(country, weight);
        } else if (shippingType.equals("express")){
            return expressShippingService.calculateShipping(country, weight);
        } else {
            return 0;
        }
    }

}
