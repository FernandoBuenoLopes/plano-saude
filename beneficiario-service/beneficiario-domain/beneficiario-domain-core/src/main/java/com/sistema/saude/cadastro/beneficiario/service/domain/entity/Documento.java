package com.sistema.saude.cadastro.beneficiario.service.domain.entity;

import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.DocumentoId;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.TipoDocumento;

import java.util.Date;

public class Documento extends BaseEntity<DocumentoId> {
    private final TipoDocumento tipoDocumento;
    private final String descricao;
    private final Date dataInclusao;
    private final Date dataAtualizacao;

    private Documento(Builder builder) {
        setId(builder.documentoId);
        tipoDocumento = builder.tipoDocumento;
        descricao = builder.descricao;
        dataInclusao = builder.dataInclusao;
        dataAtualizacao = builder.dataAtualizacao;
    }

    public static Builder builder() {
        return new Builder();
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public static final class Builder {
        private TipoDocumento tipoDocumento;
        private String descricao;
        private Date dataInclusao;
        private Date dataAtualizacao;
        private DocumentoId documentoId;

        private Builder() {
        }

        public Builder tipoDocumento(TipoDocumento val) {
            tipoDocumento = val;
            return this;
        }

        public Builder descricao(String val) {
            descricao = val;
            return this;
        }

        public Builder dataInclusao(Date val) {
            dataInclusao = val;
            return this;
        }

        public Builder dataAtualizacao(Date val) {
            dataAtualizacao = val;
            return this;
        }

        public Builder documentoId(DocumentoId val) {
            documentoId = val;
            return this;
        }

        public Documento build() {
            return new Documento(this);
        }
    }
}
