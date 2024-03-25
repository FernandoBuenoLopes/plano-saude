package com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar;

import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class DocumentosBeneficiarioResponse {

    @NotNull
    private final List<Documento> documentos;
}
