package com.plano.saude.cadastro.beneficiario.service.application.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO {
    private final String codigo;
    private final String mensagem;
}