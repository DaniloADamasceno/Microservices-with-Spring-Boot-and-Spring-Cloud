package com.microservice.hrworker.repository;

import com.microservice.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryWorker extends JpaRepository<Worker, Long> {
}
