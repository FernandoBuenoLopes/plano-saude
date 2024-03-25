package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity;

import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BeneficiarioEntityId.class)
@Table(name = "beneficiario_documentos")
@Entity
public class DocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENEFICIARIO_ID")
    private BeneficiarioEntity beneficiario;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String descricao;
    private Date dataInclusao;
    private Date dataAtualizacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoEntity that = (DocumentoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(beneficiario, that.beneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beneficiario);
    }
}
