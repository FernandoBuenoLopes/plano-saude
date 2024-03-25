package com.plano.saude.cadastro.beneficiario.service.domain.dto.remover;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RemoverBeneficiarioResponse {
    @NotNull
    private final UUID beneficiarioId;
    @NotNull
    private final String mensagem;
}
