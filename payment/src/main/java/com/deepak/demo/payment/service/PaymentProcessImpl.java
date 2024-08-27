package com.deepak.demo.payment.service;

import com.deepak.demo.payment.model.PaymentInfo;
import com.deepak.demo.payment.model.PaymentStatus;
import com.deepak.demo.payment.remote.PaymentCallbackRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class PaymentProcessImpl implements PaymentProcess{
    ConcurrentHashMap<String,PaymentStatus> dbStore = new ConcurrentHashMap<>();
    @Autowired
    PaymentCallbackRestService paymentCallbackRestService;
    @Override
    public void processPayment(String paymentId, BigDecimal amount) {
        PaymentStatus paymentStatus = processPaymentToClient(paymentId,amount);
        paymentCallbackRestService.sendStatus(new PaymentInfo(paymentId,paymentStatus));
        dbStore.put(paymentId,paymentStatus);
    }

    public PaymentStatus processPaymentToClient(String paymentId,BigDecimal amount){
        int random = ThreadLocalRandom.current().nextInt(1, 10);
        if(random%2==0){
            return PaymentStatus.SUCCESS;
        }
        return PaymentStatus.FAILED;
    }
}
