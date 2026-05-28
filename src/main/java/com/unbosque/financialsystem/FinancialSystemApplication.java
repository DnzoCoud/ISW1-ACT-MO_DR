package com.unbosque.financialsystem;

import com.unbosque.financialsystem.services.FranquiciaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinancialSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancialSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner initFranquicias(FranquiciaService franquiciaService) {
        return args -> {
            franquiciaService.cargarFranquiciasIniciales();
        };
    }
}