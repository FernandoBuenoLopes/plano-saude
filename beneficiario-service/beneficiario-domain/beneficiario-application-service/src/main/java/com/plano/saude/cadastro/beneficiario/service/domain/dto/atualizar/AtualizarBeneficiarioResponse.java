package com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class AtualizarBeneficiarioResponse {

    @NotNull
    private final UUID beneficiarioId;
    @NotNull
    private final String nome;
    @NotNull
    private final String mensagem;
}
