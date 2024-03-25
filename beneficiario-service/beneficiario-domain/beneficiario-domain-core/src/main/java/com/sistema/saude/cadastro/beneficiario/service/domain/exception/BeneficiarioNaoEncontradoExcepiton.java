package com.sistema.saude.cadastro.beneficiario.service.domain.exception;

public class BeneficiarioNaoEncontradoExcepiton extends DomainException {
    public BeneficiarioNaoEncontradoExcepiton(String message) {
        super(message);
    }

    public BeneficiarioNaoEncontradoExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}
