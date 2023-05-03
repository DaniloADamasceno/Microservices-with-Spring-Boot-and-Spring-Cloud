package com.microservices.hr_oauth.feighClients;

import com.microservices.hr_oauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/usuarios")
public interface UserFeignClient {

    //FIND BY EMAIL
    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);
}
