package com.plano.saude.cadastro.beneficiario.service.domain;

import com.plano.saude.cadastro.beneficiario.service.domain.auth.UsuarioRepository;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.BeneficiarioRepository;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.DocumentoRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.plano.saude.cadastro")
public class BeneficiarioTestConfiguration {
    @Bean
    public BeneficiarioRepository beneficiarioRepository() {
        return Mockito.mock(BeneficiarioRepository.class);
    }
    @Bean
    public UsuarioRepository usuarioRepository() {
        return Mockito.mock(UsuarioRepository.class);
    }
    @Bean
    public DocumentoRepository documentoRepository() {
        return Mockito.mock(DocumentoRepository.class);
    }
}
