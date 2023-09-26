package com.microservices.hrusers.repository;

import com.microservices.hrusers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
