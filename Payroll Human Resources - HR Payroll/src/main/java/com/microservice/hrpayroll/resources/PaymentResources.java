package com.microservice.hrpayroll.resources;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.services.ServicePayment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

    //?--------------------------------------------   Dependency Injection   -------------------------------------------
    @Autowired
    private ServicePayment servicePayment;

    //?--------------------------------------------   Methods   --------------------------------------------------------
    //FIND BY ID
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment paymentFindById = servicePayment.getPayment(workerId, days);
        return ResponseEntity.ok(paymentFindById);
    }

    //FIND BY ID - ALTERNATIVE
    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment alternativeMicroservice = new Payment("Alternative Microservice ", 01.01, days);
        return ResponseEntity.ok(alternativeMicroservice);
    }
}
