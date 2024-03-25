package com.plano.saude.cadastro.beneficiario.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.plano.saude.cadastro.beneficiario.service.dataaccess", "com.plano.saude.cadastro.beneficiario.service.domain.auth"})
@EntityScan(basePackages = {"com.plano.saude.cadastro.beneficiario.service.dataaccess", "com.plano.saude.cadastro.beneficiario.service.domain.auth"})
@SpringBootApplication(scanBasePackages =  "com.plano.saude.cadastro")
public class BeneficiarioServiceApplication {
    public static void main(String... args) {
        SpringApplication.run(BeneficiarioServiceApplication.class, args);
    }
}
