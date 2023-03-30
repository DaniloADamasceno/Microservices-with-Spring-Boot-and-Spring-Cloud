package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class ServicePayment {

public Payment getPayment(long workerId, int days) {
    return new Payment("Trabalhador de TESTE", 210.0, days);
    }

}
