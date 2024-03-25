package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.adapter;

import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.mapper.BeneficiarioDataAccessMapper;
import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.repository.DocumentoJpaRepository;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository.DocumentoRepository;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentoRepositoryImpl implements DocumentoRepository {
    private final DocumentoJpaRepository documentoJpaRepository;
    private final BeneficiarioDataAccessMapper beneficiarioDataAccessMapper;

    public DocumentoRepositoryImpl(DocumentoJpaRepository documentoJpaRepository, BeneficiarioDataAccessMapper beneficiarioDataAccessMapper) {
        this.documentoJpaRepository = documentoJpaRepository;
        this.beneficiarioDataAccessMapper = beneficiarioDataAccessMapper;
    }

    @Override
    public List<Documento> listarDocumentosBeneficiario(DocumentosBeneficiarioQuery documentosBeneficiarioQuery) {
        return beneficiarioDataAccessMapper.documentoEntitiesToDocumentos(documentoJpaRepository.findAllByBeneficiarioId(documentosBeneficiarioQuery.getBeneficiarioId()));
    }
}
