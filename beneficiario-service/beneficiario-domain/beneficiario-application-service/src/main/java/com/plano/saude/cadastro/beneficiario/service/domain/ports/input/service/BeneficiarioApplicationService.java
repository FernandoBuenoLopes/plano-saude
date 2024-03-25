package com.plano.saude.cadastro.beneficiario.service.domain.ports.input.service;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.BeneficiariosResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioResponse;
import jakarta.validation.Valid;

public interface BeneficiarioApplicationService {

    BeneficiariosResponse listarBeneficiarios();
    CriarBeneficiarioResponse criarBeneficiario(@Valid CriarBeneficiarioCommand criarBeneficiarioCommand);

    AtualizarBeneficiarioResponse atualizarBeneficiario(@Valid AtualizarBeneficiarioCommand atualizarBeneficiarioCommand);

    RemoverBeneficiarioResponse removerBeneficiario(@Valid RemoverBeneficiarioCommand removerBeneficiarioCommand);

    DocumentosBeneficiarioResponse listarDocumentosBeneficiario(@Valid DocumentosBeneficiarioQuery documentosBeneficiarioQuery);
}
