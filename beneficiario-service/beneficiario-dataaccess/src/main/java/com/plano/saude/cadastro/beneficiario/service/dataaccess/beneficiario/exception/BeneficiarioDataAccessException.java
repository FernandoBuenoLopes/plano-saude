package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.exception;

import org.springframework.dao.DataAccessException;

public class BeneficiarioDataAccessException extends DataAccessException {
    public BeneficiarioDataAccessException(String msg) {
        super(msg);
    }

    public BeneficiarioDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
