package com.microservice.hrpayroll.feignClients;

import com.microservice.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001" ,path = "/workers")       // Para dizer que o Feign Client vai se comunicar com o hr-worker
public interface WorkerFeignClient {

    //FIND BY ID
    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id );  //  --> Busca por ID
}
