package com.microservice.hrworker.resources;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repository.RepositoryWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class ResourcesWorker {


    private static Logger logger = LoggerFactory.getLogger(ResourcesWorker.class); //--> para imprimir no console

    //?--------------------------------------------   Dependency Injection   -------------------------------------------

    @Autowired
    private RepositoryWorker repositoryWorker;

    @Autowired
    private Environment environment;
    //?--------------------------------------------   Methods   --------------------------------------------------------

    //FIND ALL
    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {  //  --> Retorna uma lista de TODOS os trabalhadores
        List<Worker> listWorkerFindAll = repositoryWorker.findAll();
        return ResponseEntity.ok(listWorkerFindAll);
    }

    //FIND BY ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {  //  --> Busca por ID

        logger.info("PORT / PORTA = " + environment.getProperty("local.server.port")); //--> para imprimir no console

        Worker workerFindById = repositoryWorker.findById(id).get();
        return ResponseEntity.ok(workerFindById);
    }


}
