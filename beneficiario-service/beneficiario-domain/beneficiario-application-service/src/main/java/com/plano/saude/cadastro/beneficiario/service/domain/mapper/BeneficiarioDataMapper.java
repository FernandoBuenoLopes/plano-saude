package com.plano.saude.cadastro.beneficiario.service.domain.mapper;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarDocumentoCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioResponse;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.BeneficiarioId;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Documento;
import com.sistema.saude.cadastro.beneficiario.service.domain.valueobject.DocumentoId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BeneficiarioDataMapper {
    public Beneficiario criarBeneficiarioCommandToBeneficiario(CriarBeneficiarioCommand criarBeneficiarioCommand) {
        return Beneficiario.builder()
                .beneficiarioId(new BeneficiarioId(UUID.randomUUID()))
                .nome(criarBeneficiarioCommand.getNome())
                .telefone(criarBeneficiarioCommand.getTelefone())
                .dataNascimento(criarBeneficiarioCommand.getDataNascimento())
                .dataInclusao(criarBeneficiarioCommand.getDataInclusao())
                .dataAtualizacao(criarBeneficiarioCommand.getDataAtualizacao())
                .documentos(documentosToDocumentoEntities(criarBeneficiarioCommand.getDocumentos()))
                .build();
    }

    public CriarBeneficiarioResponse beneficiarioToCriarBeneficiarioResponse(Beneficiario beneficiario, String mensagem) {
        return CriarBeneficiarioResponse.builder()
                .beneficiarioId(beneficiario.getId().getValue())
                .mensagem(mensagem)
                .build();
    }

    private List<Documento> documentosToDocumentoEntities(List<com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.Documento> documentos) {
        return documentos.stream()
                .map(documento -> Documento.builder()
                        .tipoDocumento(documento.getTipoDocumento())
                        .descricao(documento.getDescricao())
                        .dataInclusao(documento.getDataInclusao())
                        .dataAtualizacao(documento.getDataAtualizacao())
                        .build())
                .collect(Collectors.toList());
    }

    public Beneficiario atualizarBeneficiarioCommandToBeneficiario(AtualizarBeneficiarioCommand atualizarBeneficiarioCommand) {
        return Beneficiario.builder()
                .beneficiarioId(new BeneficiarioId(UUID.fromString(atualizarBeneficiarioCommand.getId())))
                .nome(atualizarBeneficiarioCommand.getNome())
                .telefone(atualizarBeneficiarioCommand.getTelefone())
                .dataNascimento(atualizarBeneficiarioCommand.getDataNascimento())
                .dataInclusao(atualizarBeneficiarioCommand.getDataInclusao())
                .dataAtualizacao(atualizarBeneficiarioCommand.getDataAtualizacao())
                .documentos(atualizarDocumentoCommandsToDocumentoEntities(atualizarBeneficiarioCommand.getDocumentos()))
                .build();
    }

    public AtualizarBeneficiarioResponse beneficiarioToAtualizarBeneficiarioResponse(Beneficiario beneficiario, String mensagem) {
        return AtualizarBeneficiarioResponse.builder()
                .beneficiarioId(beneficiario.getId().getValue())
                .mensagem(mensagem)
                .build();
    }

    public Beneficiario removerBeneficiarioCommandToBeneficiario(RemoverBeneficiarioCommand removerBeneficiarioCommand) {
        return Beneficiario.builder()
                .beneficiarioId(new BeneficiarioId(removerBeneficiarioCommand.getBeneficiarioId()))
                .build();
    }

    public RemoverBeneficiarioResponse beneficiarioToRemoverBeneficiarioResponse(Beneficiario beneficiario, String mensagem) {
        return RemoverBeneficiarioResponse.builder()
                .beneficiarioId(beneficiario.getId().getValue())
                .mensagem(mensagem)
                .build();
    }

    public DocumentosBeneficiarioResponse documentoEntitiesToDocumentosBeneficiarioResponse(List<Documento> documentos) {
        return DocumentosBeneficiarioResponse.builder()
                .documentos(documentos.stream()
                        .map(documento -> Documento.builder()
                                .documentoId(documento.getId())
                                .tipoDocumento(documento.getTipoDocumento())
                                .descricao(documento.getDescricao())
                                .dataInclusao(documento.getDataInclusao())
                                .dataAtualizacao(documento.getDataAtualizacao())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private List<Documento> atualizarDocumentoCommandsToDocumentoEntities(List<AtualizarDocumentoCommand> atualizarDocumentoCommands) {
        return atualizarDocumentoCommands.stream()
                .map(documento -> Documento.builder()
                        .documentoId(new DocumentoId(UUID.fromString(documento.getId())))
                        .tipoDocumento(documento.getTipoDocumento())
                        .descricao(documento.getDescricao())
                        .dataInclusao(documento.getDataInclusao())
                        .dataAtualizacao(documento.getDataAtualizacao())
                        .build())
                .collect(Collectors.toList());
    }
}