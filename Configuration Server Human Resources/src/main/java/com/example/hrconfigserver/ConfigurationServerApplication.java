package com.example.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerApplication implements CommandLineRunner {

    @Value("${spring.cloud.config.server.git.username}") // pegar o valor de application.properties
    private String usernameGit;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("✅ ✅ ✅ Configuration Server started...✅ ✅ ✅");
        // Ambas as formas funcionam para pegar o valor de application.properties
        System.out.println("USERNAME GIT: " + usernameGit);
        System.out.println("USERNAME GIT: " + System.getenv("GITHUB_USER"));
        System.out.println();

    }
}
