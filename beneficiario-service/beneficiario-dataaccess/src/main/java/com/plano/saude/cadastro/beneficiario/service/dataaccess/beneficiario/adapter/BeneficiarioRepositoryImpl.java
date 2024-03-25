package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.adapter;

import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.exception.BeneficiarioDataAccessException;
import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.mapper.BeneficiarioDataAccessMapper;
import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.repository.BeneficiarioJpaRepository;
import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.repository.DocumentoJpaRepository;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.BeneficiarioRepository;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import com.sistema.saude.cadastro.beneficiario.service.domain.exception.BeneficiarioNaoEncontradoExcepiton;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.DocumentoId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.BENEFICIARIO_NAO_ENCONTRADO;
import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.ERRO_REMOCAO_BENEFICIARIO;

@Slf4j
@Component
public class BeneficiarioRepositoryImpl implements BeneficiarioRepository {
    private final BeneficiarioJpaRepository beneficiarioJpaRepository;
    private final DocumentoJpaRepository documentoJpaRepository;
    private final BeneficiarioDataAccessMapper beneficiarioDataAccessMapper;

    public BeneficiarioRepositoryImpl(BeneficiarioJpaRepository beneficiarioJpaRepository, DocumentoJpaRepository documentoJpaRepository, BeneficiarioDataAccessMapper beneficiarioDataAccessMapper) {
        this.beneficiarioJpaRepository = beneficiarioJpaRepository;
        this.documentoJpaRepository = documentoJpaRepository;
        this.beneficiarioDataAccessMapper = beneficiarioDataAccessMapper;
    }

    @Override
    public List<Beneficiario> listar() {
        return beneficiarioDataAccessMapper.beneficiarioEntitiesToBeneficiario(beneficiarioJpaRepository.findAll());
    }

    @Override
    public Beneficiario salvar(Beneficiario beneficiario) {
        return beneficiarioDataAccessMapper.beneficiarioEntityToBeneficiario(beneficiarioJpaRepository.save(beneficiarioDataAccessMapper.beneficiarioToBeneficiarioEntity(beneficiario)));
    }

    @Override
    public Beneficiario atualizar(Beneficiario beneficiario) {
        validarBeneficiario(beneficiario);
        validarDocumentos(beneficiario); // TODO: GARANTIR Q SEJAM EXCLUÍDOS OS DOCUMENTOS REMOVIDOS NA ATUALIZAÇÂO
        return beneficiarioDataAccessMapper.beneficiarioEntityToBeneficiario(beneficiarioJpaRepository.save(beneficiarioDataAccessMapper.beneficiarioToBeneficiarioEntity(beneficiario)));
    }

    @Override
    public Beneficiario remover(Beneficiario beneficiario) {
        validarBeneficiario(beneficiario);
        try {
            beneficiarioJpaRepository.deleteById(beneficiario.getId().getValue());
            return beneficiario;
        } catch (Exception e) {
            log.error(ERRO_REMOCAO_BENEFICIARIO + " -- {} -- {}",e.getCause(), e.getMessage());
            throw new BeneficiarioDataAccessException(ERRO_REMOCAO_BENEFICIARIO);
        }
    }

    private void validarBeneficiario(Beneficiario beneficiario) {
        if(!beneficiarioJpaRepository.existsById(beneficiario.getId().getValue())) {
            log.error(BENEFICIARIO_NAO_ENCONTRADO);
            throw new BeneficiarioNaoEncontradoExcepiton(BENEFICIARIO_NAO_ENCONTRADO);
        }
    }

    private void validarDocumentos(Beneficiario beneficiario) {
//        var documentosSalvos = beneficiarioDataAccessMapper.documentoEntitiesToDocumentos(documentoJpaRepository.findAllByBeneficiarioId(beneficiario.getId().getValue()));
//        documentosSalvos.forEach(documento -> {
//            if(!beneficiario.getDocumentos().contains(documento))
//                documentoJpaRepository.deleteById(documento.getId().getValue());
//        });
        documentoJpaRepository.deleteAllByBeneficiarioId(beneficiario.getId().getValue());
    }
}
