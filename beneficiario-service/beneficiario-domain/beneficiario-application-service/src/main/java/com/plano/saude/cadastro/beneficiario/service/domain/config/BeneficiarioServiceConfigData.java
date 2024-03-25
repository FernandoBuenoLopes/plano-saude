package com.plano.saude.cadastro.beneficiario.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "beneficiario-service")
public class BeneficiarioServiceConfigData {
}
