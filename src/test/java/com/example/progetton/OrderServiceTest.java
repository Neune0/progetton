package com.example.progetton;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) 
public class OrderServiceTest {
    
    private final ShippingService standardShippingService = new StandardShippingService();
    private final ShippingService expressShippingService = new ExpressShippingService();
    private final ShippingService customExpressShippingService = new CustomExpressShippingService();


    @Test
    public void testCalculateShippingStandard(){
        OrderService orderService = new OrderService(standardShippingService, expressShippingService);
        double shippingCost = orderService.getTotalShipping("standard","USA", 10);
        assert(shippingCost == 10 + 10 *1.5);
    }

    @Test
    public void testCalculateShippingExpress(){
        OrderService orderService = new OrderService(standardShippingService, expressShippingService);
        double shippingCost = orderService.getTotalShipping("express","USA", 10);
        assert(shippingCost == 25 + 10 * 3);
    }

    @Test
    public void testCalculateShippingCustomExpress(){
        OrderService orderService = new OrderService(standardShippingService, customExpressShippingService);
        double shippingCost = orderService.getTotalShipping("express","USA", 10);
        assert(shippingCost == 20 + 10 * 2.5);
    }
   
}
