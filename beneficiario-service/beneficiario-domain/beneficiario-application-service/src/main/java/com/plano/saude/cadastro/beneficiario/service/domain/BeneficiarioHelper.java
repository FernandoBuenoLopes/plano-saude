package com.plano.saude.cadastro.beneficiario.service.domain;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.mapper.BeneficiarioDataMapper;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.BeneficiarioRepository;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.DocumentoRepository;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;
import com.sistema.saude.cadastro.beneficiario.service.domain.exception.BeneficiarioDomainExcepiton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.*;

@Slf4j
@Component
public class BeneficiarioHelper {
    private final BeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioDataMapper  beneficiarioDataMapper;
    private final DocumentoRepository documentoRepository;

    public BeneficiarioHelper(BeneficiarioRepository beneficiarioRepository, BeneficiarioDataMapper beneficiarioDataMapper, DocumentoRepository documentoRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
        this.beneficiarioDataMapper = beneficiarioDataMapper;
        this.documentoRepository = documentoRepository;
    }

    @Transactional
    public Beneficiario salvarBeneficiario(CriarBeneficiarioCommand criarBeneficiarioCommand) {
        Beneficiario beneficiario = beneficiarioDataMapper.criarBeneficiarioCommandToBeneficiario(criarBeneficiarioCommand);
        beneficiario.inicializarBeneficiario();
        Beneficiario beneficiarioResult = validarSalvarBeneficiario(beneficiario);
        log.info(BENEFICIARIO_CRIADO, beneficiarioResult.getId().getValue());
        return beneficiarioResult;
    }

    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.listar();
    }

    @Transactional
    public Beneficiario atualizarBeneficiario(AtualizarBeneficiarioCommand atualizarBeneficiarioCommand) {
        Beneficiario beneficiario = beneficiarioDataMapper.atualizarBeneficiarioCommandToBeneficiario(atualizarBeneficiarioCommand);
        Beneficiario beneficiarioResult = validarAtualizarBeneficiario(beneficiario);
        log.info(BENEFICIARIO_ATUALIZADO ,beneficiarioResult.getId().getValue());
        return beneficiarioResult;
    }

    @Transactional
    public Beneficiario removerBeneficiario(RemoverBeneficiarioCommand removerBeneficiarioCommand) {
        Beneficiario beneficiario = beneficiarioDataMapper.removerBeneficiarioCommandToBeneficiario(removerBeneficiarioCommand);
        Beneficiario beneficiarioResult = validarRemoverBeneficiario(beneficiario);
        log.info(BENEFICIARIO_REMOVIDO ,beneficiarioResult.getId().getValue());
        return beneficiarioResult;
    }

    private Beneficiario validarSalvarBeneficiario(Beneficiario beneficiario) {
        Beneficiario beneficiarioResult = beneficiarioRepository.salvar(beneficiario);
        if(beneficiarioResult == null) {
            log.error(IMPOSSIVEL_X_BENEFICIARIO(SALVAR));
            throw new BeneficiarioDomainExcepiton(IMPOSSIVEL_X_BENEFICIARIO(SALVAR));
        }
        return beneficiarioResult;
    }

    private Beneficiario validarAtualizarBeneficiario(Beneficiario beneficiario) {
        Beneficiario beneficiarioResult = beneficiarioRepository.atualizar(beneficiario);
        if(beneficiarioResult == null) {
            log.error(IMPOSSIVEL_X_BENEFICIARIO(ATUALIZAR));
            throw new BeneficiarioDomainExcepiton(IMPOSSIVEL_X_BENEFICIARIO(ATUALIZAR));
        }
        return beneficiarioResult;
    }

    private Beneficiario validarRemoverBeneficiario(Beneficiario beneficiario) {
        Beneficiario beneficiarioResult = beneficiarioRepository.remover(beneficiario);
        if(beneficiarioResult == null) {
            log.error(IMPOSSIVEL_X_BENEFICIARIO(REMOVER));
            throw new BeneficiarioDomainExcepiton(IMPOSSIVEL_X_BENEFICIARIO(REMOVER));
        }
        return beneficiarioResult;
    }

    public List<Documento> listarDocumentosBeneficiario(DocumentosBeneficiarioQuery documentosBeneficiarioQuery) {
        return documentoRepository.listarDocumentosBeneficiario(documentosBeneficiarioQuery);
    }
}
