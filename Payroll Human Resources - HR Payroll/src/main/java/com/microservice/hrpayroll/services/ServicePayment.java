package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServicePayment {

    @Value("${hr-worker.host}") // Para pegar o valor da variável de ambiente
    private String workersHumanResourcesUrlHost;

    @Autowired
    private RestTemplate restTemplate;

    //? --------------------------------------------   Methods    ------------------------------------------------------
public Payment getPayment(long workerId, int days) {
    // Mapa de variáveis de URI
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("id", "" + workerId); // --> .put pega os valores do id e do workerID
    //converter um long em String --> "" + workerId = String.valueOf(workerId)

    Worker worker = restTemplate.getForObject(workersHumanResourcesUrlHost + "/workers/{id}", Worker.class, uriVariables);
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
