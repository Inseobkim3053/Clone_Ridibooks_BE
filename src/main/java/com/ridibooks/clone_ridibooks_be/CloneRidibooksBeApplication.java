package com.ridibooks.clone_ridibooks_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CloneRidibooksBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloneRidibooksBeApplication.class, args);
    }

}
