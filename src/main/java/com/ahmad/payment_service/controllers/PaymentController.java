package com.ahmad.payment_service.controllers;

import com.ahmad.payment_service.dtos.CreatePaymentLinkDto;
import com.ahmad.payment_service.services.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments/")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("createPaymentLink")
    public String createPaymentLink(@RequestBody CreatePaymentLinkDto requestDto){
        return paymentService.createPaymentLink(requestDto.getOrderId());
    }



}
