package com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar;

import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class AtualizarDocumentoCommand {
    private final String id;
    private final TipoDocumento tipoDocumento;
    private final String descricao;
    private final Date dataInclusao;
    private final Date dataAtualizacao;
}
