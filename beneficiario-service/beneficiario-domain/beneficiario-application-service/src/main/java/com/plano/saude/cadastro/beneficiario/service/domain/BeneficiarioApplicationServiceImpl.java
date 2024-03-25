package com.plano.saude.cadastro.beneficiario.service.domain;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.BeneficiariosResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.input.service.BeneficiarioApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class BeneficiarioApplicationServiceImpl implements BeneficiarioApplicationService {
    private final BeneficiarioCommandHandler beneficiarioCommandHandler;

    public BeneficiarioApplicationServiceImpl(BeneficiarioCommandHandler beneficiarioCommandHandler) {

        this.beneficiarioCommandHandler = beneficiarioCommandHandler;
    }

    @Override
    public BeneficiariosResponse listarBeneficiarios() {

        return beneficiarioCommandHandler.listarBeneficiarios();
    }

    @Override
    public CriarBeneficiarioResponse criarBeneficiario(CriarBeneficiarioCommand criarBeneficiarioCommand) {

        return beneficiarioCommandHandler.criarBeneficiario(criarBeneficiarioCommand);
    }

    @Override
    public AtualizarBeneficiarioResponse atualizarBeneficiario(AtualizarBeneficiarioCommand atualizarBeneficiarioCommand) {

        return beneficiarioCommandHandler.atualizarBeneficiario(atualizarBeneficiarioCommand);
    }

    @Override
    public RemoverBeneficiarioResponse removerBeneficiario(RemoverBeneficiarioCommand removerBeneficiarioCommand) {

        return beneficiarioCommandHandler.removerBeneficiario(removerBeneficiarioCommand);
    }

    @Override
    public DocumentosBeneficiarioResponse listarDocumentosBeneficiario(DocumentosBeneficiarioQuery documentosBeneficiarioQuery) {

        return beneficiarioCommandHandler.listarDocumentosBeneficiario(documentosBeneficiarioQuery);
    }
}
