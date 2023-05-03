package com.microservices.hr_oauth.resources;

import com.microservices.hr_oauth.entities.User;
import com.microservices.hr_oauth.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class ResourceUser {

    //? --------------------------------------------  Injeção de Dependência  ------------------------------------------
    @Autowired
    private ServiceUser serviceUser;


    //? --------------------------------------------   Methods -> End-Points  ------------------------------------------
    //FIND BY EMAIL
    @RequestMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {                   //  --> Busca por EMAIL
        try {
            User userFindByEmail = serviceUser.findByEmail(email);
            return ResponseEntity.ok(userFindByEmail);
        } catch (IllegalArgumentException illegalArgumentException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
