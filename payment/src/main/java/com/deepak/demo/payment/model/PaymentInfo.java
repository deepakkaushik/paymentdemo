package com.deepak.demo.payment.model;
public class PaymentInfo {
    String paymentId;
    PaymentStatus paymentStatus;

    public PaymentInfo(String paymentId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
