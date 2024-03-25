package com.plano.saude.cadastro.beneficiario.service.domain.dto.remover;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RemoverBeneficiarioCommand {
    @NotNull
    private final UUID beneficiarioId;
}
