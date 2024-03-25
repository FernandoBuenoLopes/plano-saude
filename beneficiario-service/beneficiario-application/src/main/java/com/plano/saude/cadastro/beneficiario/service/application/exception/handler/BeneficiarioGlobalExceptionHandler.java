package com.plano.saude.cadastro.beneficiario.service.application.exception.handler;

import com.sistema.saude.cadastro.beneficiario.service.domain.exception.BeneficiarioDomainExcepiton;
import com.sistema.saude.cadastro.beneficiario.service.domain.exception.BeneficiarioNaoEncontradoExcepiton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class BeneficiarioGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {BeneficiarioDomainExcepiton.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(BeneficiarioDomainExcepiton beneficiarioDomainException) {
        log.error((beneficiarioDomainException.getMessage()), beneficiarioDomainException);
        return ErrorDTO.builder()
                .codigo(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .mensagem(beneficiarioDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {BeneficiarioNaoEncontradoExcepiton.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(BeneficiarioNaoEncontradoExcepiton beneficiarioNaoEncontradoException) {
        log.error((beneficiarioNaoEncontradoException.getMessage()), beneficiarioNaoEncontradoException);
        return ErrorDTO.builder()
                .codigo(HttpStatus.NOT_FOUND.getReasonPhrase())
                .mensagem(beneficiarioNaoEncontradoException.getMessage())
                .build();
    }
}