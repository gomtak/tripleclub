package com.tripleclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TripleclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripleclubApplication.class, args);
    }

}
