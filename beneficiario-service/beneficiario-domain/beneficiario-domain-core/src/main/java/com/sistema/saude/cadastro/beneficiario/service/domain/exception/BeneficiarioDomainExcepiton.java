package com.sistema.saude.cadastro.beneficiario.service.domain.exception;

public class BeneficiarioDomainExcepiton extends DomainException {
    public BeneficiarioDomainExcepiton(String message) {
        super(message);
    }

    public BeneficiarioDomainExcepiton(String message, Throwable cause) {
        super(message, cause);
    }
}
