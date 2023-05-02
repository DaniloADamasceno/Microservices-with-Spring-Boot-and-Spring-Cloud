package com.microservices.hrusers.resources;

import com.microservices.hrusers.entities.User;
import com.microservices.hrusers.repository.RepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope                                   //--> Para atualizar o valor da variável em tempo de execução
@RestController
@RequestMapping(value = "/usuarios")
public class ResourcesUser {

    private static final Logger logger = LoggerFactory.getLogger(ResourcesUser.class); //--> para imprimir no console


    //? -----------------------------------------  Injeção de Dependência  ---------------------------------------------
    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private Environment environment;

    //? --------------------------------------------   Methods -> End-Points  ------------------------------------------
    //FIND ALL
    @GetMapping
    public ResponseEntity<List<User>> findAll() {               //  --> Retorna uma lista de TODOS os Usuarios
        List<User> listUserFindAll = repositoryUser.findAll();
        return ResponseEntity.ok(listUserFindAll);
    }

    //FIND BY ID
    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id) {                   //  --> Busca por ID
        logger.info("PORT / PORTA = " + environment.getProperty("local.server.port"));  //--> para imprimir no console
        User userFindById = repositoryUser.findById(id).get();
        return ResponseEntity.ok(userFindById);
    }

    //FIND BY EMAIL
    @RequestMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {                   //  --> Busca por EMAIL
        logger.info("PORT / PORTA = " + environment.getProperty("local.server.port"));  //--> para imprimir no console
        User userFindByEmail = repositoryUser.findByEmail(email);
        return ResponseEntity.ok(userFindByEmail);
    }
}
