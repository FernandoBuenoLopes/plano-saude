package com.plano.saude.cadastro.beneficiario.service.domain;

import com.sistema.saude.cadastro.beneficiario.service.domain.BeneficiarioDomainService;
import com.sistema.saude.cadastro.beneficiario.service.domain.BeneficiarioDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public BeneficiarioDomainService beneficiarioDomainService() {
        return new BeneficiarioDomainServiceImpl();
    }

}
