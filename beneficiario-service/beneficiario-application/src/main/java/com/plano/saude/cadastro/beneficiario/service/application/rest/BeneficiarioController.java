package com.plano.saude.cadastro.beneficiario.service.application.rest;

import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.atualizar.AtualizarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.BeneficiariosResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioQuery;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar.DocumentosBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.criar.CriarBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioCommand;
import com.plano.saude.cadastro.beneficiario.service.domain.dto.remover.RemoverBeneficiarioResponse;
import com.plano.saude.cadastro.beneficiario.service.domain.ports.input.service.BeneficiarioApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.*;

@Slf4j
@RestController
@RequestMapping(value ="/beneficiario", produces = "application/vnd.api.v1+json")
public class BeneficiarioController {
    private final BeneficiarioApplicationService beneficiarioApplicationService;

    public BeneficiarioController(BeneficiarioApplicationService beneficiarioApplicationService) {
        this.beneficiarioApplicationService = beneficiarioApplicationService;
    }

    @GetMapping("/listar")
    public ResponseEntity<BeneficiariosResponse> listarBeneficiarios() {
        log.info(CONSULTANDO_BENEFICIARIOS);
        BeneficiariosResponse beneficiariosResponse = beneficiarioApplicationService.listarBeneficiarios();
        log.info(CONSULTA_BENEFICIARIOS_BEM_SUCEDIDA);
        return ResponseEntity.ok(beneficiariosResponse);
    }

    @PostMapping("/criar")
    public ResponseEntity<CriarBeneficiarioResponse> criar(@RequestBody CriarBeneficiarioCommand criarBeneficiarioCommand) {
        log.info(CADASTRANDO_BENEFICIARIO, criarBeneficiarioCommand.getNome());
        CriarBeneficiarioResponse criarBeneficiarioResponse = beneficiarioApplicationService.criarBeneficiario(criarBeneficiarioCommand);
        log.info(BENEFICIARIO_CADASTRADO_SUCESSO, criarBeneficiarioCommand.getNome(), criarBeneficiarioResponse.getBeneficiarioId());
        return ResponseEntity.ok(criarBeneficiarioResponse);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<AtualizarBeneficiarioResponse> atualizar(@RequestBody AtualizarBeneficiarioCommand atualizarBeneficiarioCommand) {
        log.info(ATUALIZANDO_BENEFICIARIO, atualizarBeneficiarioCommand.getId());
        AtualizarBeneficiarioResponse atualizarBeneficiarioResponse = beneficiarioApplicationService.atualizarBeneficiario(atualizarBeneficiarioCommand);
        log.info(BENEFICIARIO_ATUALIZADO_SUCESSO, atualizarBeneficiarioResponse.getBeneficiarioId());
        return ResponseEntity.ok(atualizarBeneficiarioResponse);
    }

    @DeleteMapping("/remover/{beneficiarioId}")
    public ResponseEntity<RemoverBeneficiarioResponse> criarBeneficiario(@PathVariable UUID beneficiarioId) {
        log.info(REMOVENDO_BENEFICIARIO, beneficiarioId);
        RemoverBeneficiarioResponse removerBeneficiarioResponse = beneficiarioApplicationService.removerBeneficiario(RemoverBeneficiarioCommand.builder().beneficiarioId(beneficiarioId).build());
        log.info(BENEFICIARIO_REMOVIDO_SUCESSO, removerBeneficiarioResponse.getBeneficiarioId());
        return ResponseEntity.ok(removerBeneficiarioResponse);
    }

    @GetMapping("/documentos")
    public ResponseEntity<DocumentosBeneficiarioResponse> listarDocumentosBeneficiario(@RequestParam UUID beneficiairoId) {
        DocumentosBeneficiarioResponse documentosBeneficiarioResponse = beneficiarioApplicationService.listarDocumentosBeneficiario(DocumentosBeneficiarioQuery.builder().beneficiarioId(beneficiairoId).build());
        return ResponseEntity.ok(documentosBeneficiarioResponse);
    }
}
