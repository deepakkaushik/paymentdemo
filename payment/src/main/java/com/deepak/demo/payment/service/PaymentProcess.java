package com.deepak.demo.payment.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public interface PaymentProcess {
    void processPayment(String paymentId, BigDecimal amount);
}
