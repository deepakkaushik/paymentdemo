package com.deepak.demo.payment.remote;

import com.deepak.demo.payment.model.PaymentInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentCallbackRestService {

    public static final String callbackURL = "http://localhost:8083/payment/update";

    public Boolean sendStatus(PaymentInfo paymentInfo){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(callbackURL,paymentInfo, Boolean.class);
    }
}
