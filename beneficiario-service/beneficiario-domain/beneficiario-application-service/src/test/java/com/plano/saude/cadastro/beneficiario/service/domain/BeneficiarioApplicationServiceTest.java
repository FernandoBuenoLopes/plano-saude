package com.plano.saude.cadastro.beneficiario.service.domain;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.BeneficiariosResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.Documento;
import com.plano.saude.cadastro.beneficiario.service.domain.mapper.BeneficiarioDataMapper;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.input.service.BeneficiarioApplicationService;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.BeneficiarioRepository;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.TipoDocumento;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = BeneficiarioTestConfiguration.class)
public class BeneficiarioApplicationServiceTest {
    @Autowired
    private BeneficiarioApplicationService beneficiarioApplicationService;
    @Autowired
    private BeneficiarioDataMapper beneficiarioDataMapper;
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    private CriarBeneficiarioCommand criarBeneficiarioCommandErrado;

    @BeforeAll
    public void init() {
        criarBeneficiarioCommandErrado = CriarBeneficiarioCommand.builder()
                .dataNascimento(Date.from(Instant.now()))
                .dataInclusao(Date.from(Instant.now()))
                .telefone(987654321)
                .documentos(Arrays.asList(new Documento[]{Documento.builder()
                        .tipoDocumento(TipoDocumento.RG)
                        .descricao("9876543162")
                        .dataInclusao(Date.from(Instant.now()))
                        .build()}))
                .build();
    }

    @Test
    public void testListarBeneficiarios() {
        var response = beneficiarioApplicationService.listarBeneficiarios();
        assertInstanceOf(BeneficiariosResponse.class, response);
    }

    @Test
    public void testCriarBeneficiario() {
        ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class,
                () -> beneficiarioApplicationService.criarBeneficiario(criarBeneficiarioCommandErrado));
    }


}
