package com.ahmad.payment_service.configurations;

import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentGatewayConfiguration {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Bean
    StripeClient createStripeClient(){
        return new StripeClient(stripeApiKey);
    }

}
