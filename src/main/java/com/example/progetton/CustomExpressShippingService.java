package com.example.progetton;

public class CustomExpressShippingService implements ShippingService{
    
    @Override
    double calculateShipping(String country, double weight){
        switch (country){
            case "USA":
                return 12.0 + weight * 1.8;
            case "Europe":
                return 22.0 + weight * 2.3;
            case "Other":
                return 35.0 + weight * 2.8;
            default:
                return 0;
        }
    }
}
