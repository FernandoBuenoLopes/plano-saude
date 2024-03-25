package com.sistema.saude.cadastro.beneficiario.service.domain.entity;

import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.BeneficiarioId;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Beneficiario extends AggregateRoot<BeneficiarioId> {

    private final String nome;
    private final int telefone;
    private final Date dataNascimento;
    private final Date dataInclusao;
    private final Date dataAtualizacao;
    private final List<Documento> documentos;

    public void inicializarBeneficiario() {
        setId(new BeneficiarioId(UUID.randomUUID()));
    }

    private Beneficiario(Builder builder) {
        this.documentos = builder.documentos;
        setId(builder.beneficiarioId);
        nome = builder.nome;
        telefone = builder.telefone;
        dataNascimento = builder.dataNascimento;
        dataInclusao = builder.dataInclusao;
        dataAtualizacao = builder.dataAtualizacao;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public List<Documento> getDocumentos() {
        return documentos;
    }

    public static final class Builder {
        private String nome;
        private int telefone;
        private Date dataNascimento;
        private Date dataInclusao;
        private Date dataAtualizacao;
        private BeneficiarioId beneficiarioId;
        public List<Documento> documentos;

        private Builder() {
        }

        public Builder nome(String val) {
            nome = val;
            return this;
        }

        public Builder telefone(int val) {
            telefone = val;
            return this;
        }

        public Builder dataNascimento(Date val) {
            dataNascimento = val;
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

        public Builder documentos(List<Documento> val) {
            documentos = val;
            return this;
        }

        public Builder beneficiarioId(BeneficiarioId val) {
            beneficiarioId = val;
            return this;
        }

        public Beneficiario build() {
            return new Beneficiario(this);
        }
    }
}
