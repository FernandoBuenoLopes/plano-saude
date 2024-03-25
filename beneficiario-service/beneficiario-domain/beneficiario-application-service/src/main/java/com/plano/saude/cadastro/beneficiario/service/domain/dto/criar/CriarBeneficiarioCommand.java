package com.plano.saude.cadastro.beneficiario.service.domain.dto.criar;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class CriarBeneficiarioCommand {
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
    private final List<Documento> documentos;

}
