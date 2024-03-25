package com.plano.saude.cadastro.beneficiario.service.domain.dto.criar;

import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.TipoDocumento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Getter
@Builder
@AllArgsConstructor
public class Documento {
    @NotNull
    private final TipoDocumento tipoDocumento;
    @NotNull
    private final String descricao;
    @NotNull
    private final Date dataInclusao;
    @NotNull
    private final Date dataAtualizacao;
}
