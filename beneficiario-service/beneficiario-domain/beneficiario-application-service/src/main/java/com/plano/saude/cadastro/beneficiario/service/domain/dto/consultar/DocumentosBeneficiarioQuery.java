package com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DocumentosBeneficiarioQuery {
    @NotNull
    private final UUID beneficiarioId;
}
