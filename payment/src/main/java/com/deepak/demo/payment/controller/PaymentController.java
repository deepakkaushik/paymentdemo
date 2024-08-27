package com.deepak.demo.payment.controller;

import com.deepak.demo.payment.model.Payment;
import com.deepak.demo.payment.model.PaymentInfo;
import com.deepak.demo.payment.model.PaymentStatus;
import com.deepak.demo.payment.service.PaymentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {
     @Autowired
     private PaymentProcess paymentProcess;

     @PostMapping("/submit")
     public ResponseEntity<PaymentInfo> paymentSubmit(@RequestBody Payment payment){
         paymentProcess.processPayment(payment.getPaymentId(), payment.getAmount());
         return ResponseEntity.status(HttpStatus.OK).body(getResponse(payment.getPaymentId()));
     }

     private PaymentInfo getResponse(String paymentId){
         return new PaymentInfo(paymentId,PaymentStatus.PROCESSING);
    }


}
