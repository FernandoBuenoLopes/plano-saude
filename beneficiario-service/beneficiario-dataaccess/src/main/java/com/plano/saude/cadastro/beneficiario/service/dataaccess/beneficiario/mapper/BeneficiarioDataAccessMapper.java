package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.mapper;

import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity.BeneficiarioEntity;
import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity.DocumentoEntity;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.BeneficiarioId;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.DocumentoId;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class BeneficiarioDataAccessMapper {

    public Beneficiario beneficiarioEntityToBeneficiario(BeneficiarioEntity beneficiarioEntity) {
        return Beneficiario.builder()
                .beneficiarioId(new BeneficiarioId(beneficiarioEntity.getId()))
                .nome(beneficiarioEntity.getNome())
                .telefone(beneficiarioEntity.getTelefone())
                .dataNascimento(beneficiarioEntity.getDataNascimento())
                .dataInclusao(beneficiarioEntity.getDataInclusao())
                .dataAtualizacao(beneficiarioEntity.getDataAtualizacao())
                .documentos(documentoEntitiesToDocumentos(beneficiarioEntity.getDocumentos()))
                .build();
    }

    public BeneficiarioEntity beneficiarioToBeneficiarioEntity(Beneficiario beneficiario) {
        BeneficiarioEntity beneficiarioEntity = BeneficiarioEntity.builder()
                .id(beneficiario.getId().getValue())
                .nome(beneficiario.getNome())
                .telefone(beneficiario.getTelefone())
                .dataNascimento(beneficiario.getDataNascimento())
                .dataInclusao(beneficiario.getDataInclusao())
                .dataAtualizacao(beneficiario.getDataAtualizacao())
                .documentos(documentosToDocumentoEntities(beneficiario.getDocumentos()))
                .build();

        beneficiarioEntity.getDocumentos().forEach(documentoEntity -> documentoEntity.setBeneficiario(beneficiarioEntity));

        return beneficiarioEntity;
    }

    public List<Beneficiario> beneficiarioEntitiesToBeneficiario(List<BeneficiarioEntity> beneficiarioEntities) {
        return beneficiarioEntities.stream()
                .map(beneficiarioEntity -> Beneficiario.builder()
                        .beneficiarioId(new BeneficiarioId(beneficiarioEntity.getId()))
                        .nome(beneficiarioEntity.getNome())
                        .telefone(beneficiarioEntity.getTelefone())
                        .dataNascimento(beneficiarioEntity.getDataNascimento())
                        .dataInclusao(beneficiarioEntity.getDataInclusao())
                        .dataAtualizacao(beneficiarioEntity.getDataAtualizacao())
                        .documentos(documentoEntitiesToDocumentos(beneficiarioEntity.getDocumentos()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Documento> documentoEntitiesToDocumentos(List<DocumentoEntity> documentos) {
        return documentos.stream()
                .map(documentoEntity -> Documento.builder()
                        .documentoId(new DocumentoId(documentoEntity.getId()))
                        .tipoDocumento(documentoEntity.getTipoDocumento())
                        .descricao(documentoEntity.getDescricao())
                        .dataInclusao(documentoEntity.getDataInclusao())
                        .dataAtualizacao(documentoEntity.getDataAtualizacao())
                        .build())
                .collect(Collectors.toList());

    }

    private List<DocumentoEntity> documentosToDocumentoEntities(List<Documento> documentos) {
        return documentos.stream()
                .map(documento -> DocumentoEntity.builder()
                        .id(documento.getId() == null ? null : documento.getId().getValue())
                        .tipoDocumento(documento.getTipoDocumento())
                        .descricao(documento.getDescricao())
                        .dataInclusao(documento.getDataInclusao())
                        .dataAtualizacao(documento.getDataAtualizacao())
                        .build())
                .collect(Collectors.toList());
    }
}
