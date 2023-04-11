package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import com.microservice.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePayment {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    //? --------------------------------------------   Methods    ------------------------------------------------------
public Payment getPayment(long workerId, int days) {

    Worker worker =workerFeignClient.findById(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
