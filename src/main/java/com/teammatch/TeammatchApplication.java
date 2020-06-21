package com.teammatch;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TeammatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeammatchApplication.class, args);
    }

    @Bean //agregar
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
