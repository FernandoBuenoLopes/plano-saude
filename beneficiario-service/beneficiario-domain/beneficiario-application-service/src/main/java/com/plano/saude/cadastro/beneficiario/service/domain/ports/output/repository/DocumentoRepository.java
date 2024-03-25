package com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;

import java.util.List;

public interface DocumentoRepository {
    List<Documento> listarDocumentosBeneficiario(DocumentosBeneficiarioQuery documentosBeneficiarioQuery);
}
