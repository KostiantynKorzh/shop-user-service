package me.study.user_service.service;

import me.study.user_service.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoService {

    public static final String PAYMENT_SERVICE_URL = "http://localhost:8083/payments/user?userId=";

    @Autowired
    private RestTemplate restTemplate;

    public Payment[] getAllPaymentsByUserId(Long userId) {
        return restTemplate.getForEntity(PAYMENT_SERVICE_URL + userId, Payment[].class).getBody();
    }

}
