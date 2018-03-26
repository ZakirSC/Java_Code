package com.burnaev.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.burnaev")
@EntityScan(basePackages = "com.burnaev.models")
@EnableJpaRepositories(basePackages = "com.burnaev.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
