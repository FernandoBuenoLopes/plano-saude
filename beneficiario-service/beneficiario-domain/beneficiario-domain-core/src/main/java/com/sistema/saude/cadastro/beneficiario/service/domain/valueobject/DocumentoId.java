package com.sistema.saude.cadastro.beneficiario.service.domain.valueobject;

import java.util.UUID;

public class DocumentoId extends BaseId<UUID> {
    public DocumentoId(UUID value) {
        super(value);
    }
}
