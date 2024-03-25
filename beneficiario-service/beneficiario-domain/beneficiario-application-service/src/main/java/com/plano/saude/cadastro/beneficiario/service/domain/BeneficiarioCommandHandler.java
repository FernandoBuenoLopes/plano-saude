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
import com.plano.saude.cadastro.beneficiario.service.domain.mapper.BeneficiarioDataMapper;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.*;

@Slf4j
@Component
public class BeneficiarioCommandHandler {
    private final BeneficiarioHelper beneficiarioHelper;
    private final BeneficiarioDataMapper beneficiarioDataMapper;

    public BeneficiarioCommandHandler(BeneficiarioHelper beneficiarioHelper, BeneficiarioDataMapper beneficiarioDataMapper) {
        this.beneficiarioHelper = beneficiarioHelper;
        this.beneficiarioDataMapper = beneficiarioDataMapper;
    }

    public BeneficiariosResponse listarBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioHelper.listarBeneficiarios();
        return new BeneficiariosResponse(beneficiarios);
    }

    public CriarBeneficiarioResponse criarBeneficiario(CriarBeneficiarioCommand criarBeneficiarioCommand) {
        Beneficiario beneficiario = beneficiarioHelper.salvarBeneficiario(criarBeneficiarioCommand);

        return beneficiarioDataMapper.beneficiarioToCriarBeneficiarioResponse(beneficiario, BENEFICIARIO_X_COM_SUCESSO(CRIADO));
    }

    public AtualizarBeneficiarioResponse atualizarBeneficiario(AtualizarBeneficiarioCommand atualizarBeneficiarioCommand) {

        return beneficiarioDataMapper.beneficiarioToAtualizarBeneficiarioResponse(beneficiarioHelper.atualizarBeneficiario(atualizarBeneficiarioCommand), BENEFICIARIO_X_COM_SUCESSO(ATUALIZADO));
    }

    public RemoverBeneficiarioResponse removerBeneficiario(RemoverBeneficiarioCommand removerBeneficiarioCommand) {

        return beneficiarioDataMapper.beneficiarioToRemoverBeneficiarioResponse(beneficiarioHelper.removerBeneficiario(removerBeneficiarioCommand), BENEFICIARIO_X_COM_SUCESSO(REMOVIDO));
    }

    public DocumentosBeneficiarioResponse listarDocumentosBeneficiario(DocumentosBeneficiarioQuery documentosBeneficiarioQuery) {

        return beneficiarioDataMapper.documentoEntitiesToDocumentosBeneficiarioResponse(beneficiarioHelper.listarDocumentosBeneficiario(documentosBeneficiarioQuery));
    }
}
