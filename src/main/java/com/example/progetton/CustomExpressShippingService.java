package com.example.progetton;

public class CustomExpressShippingService implements ShippingService{
    
    @Override
    public double calculateShipping(String country, double weight){
        switch (country){
            case "USA":
                return 20 + weight * 2.5;
            case "Europe":
                return 25 + weight * 3;
            case "Other":
                return 35 + weight * 3.5;
            default:
                return 0;
        }
    }
}
