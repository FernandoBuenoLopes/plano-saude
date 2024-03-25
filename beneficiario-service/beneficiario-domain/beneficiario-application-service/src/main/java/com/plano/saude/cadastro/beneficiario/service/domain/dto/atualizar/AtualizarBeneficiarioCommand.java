package com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class AtualizarBeneficiarioCommand {
    @NotNull
    private final String id;
    @NotNull
    private final String nome;
    @NotNull
    private final int telefone;
    @NotNull
    private final Date dataNascimento;
    @NotNull
    private final Date dataInclusao;
    private final Date dataAtualizacao;
    @NotNull
    private final List<AtualizarDocumentoCommand> documentos;
}
