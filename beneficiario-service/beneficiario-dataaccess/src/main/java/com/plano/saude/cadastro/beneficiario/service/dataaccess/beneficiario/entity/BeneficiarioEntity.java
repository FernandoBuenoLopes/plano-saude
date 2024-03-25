package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "beneficiarios")
@Entity
public class BeneficiarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private int telefone;
    private Date dataNascimento;
    private Date dataInclusao;
    private Date dataAtualizacao;
    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    private List<DocumentoEntity> documentos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioEntity that = (BeneficiarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
