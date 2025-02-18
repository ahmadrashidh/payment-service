package com.ahmad.payment_service.services;

import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StripePaymentService implements PaymentService{

    private final StripeClient client;

    public StripePaymentService(StripeClient stripeClient){
        this.client = stripeClient;
    }

    @Override
    public String createPaymentLink(String orderId) {
        try {
            PriceCreateParams priceParams =
                    PriceCreateParams.builder()
                            .setCurrency("eur")
                            .setUnitAmount(100L)
                            .setProductData(PriceCreateParams.ProductData.builder().setName("Custom Payment").build())
                            .build();

            Price price = client.prices().create(priceParams);

            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            )
                            .build();

            PaymentLink paymentLink = client.paymentLinks().create(params);

            System.out.println(paymentLink.getId());

            return paymentLink.getUrl();

        } catch(StripeException ex){
            System.out.println(ex);
        }

        return null;

    }
}
