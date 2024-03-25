package com.plano.saude.cadastro.beneficiario.service.application.exception.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

import static com.sistema.saude.cadastro.beneficiario.service.domain.DomainConstants.ERRO_INESPERADO;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ErrorDTO.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .mensagem(ERRO_INESPERADO)
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(ValidationException e) {
        ErrorDTO errorDTO;
        if (e instanceof ConstraintViolationException) {
            String violations = extractViolationFromException((ConstraintViolationException) e);
            log.error(violations, e);
            errorDTO = ErrorDTO.builder()
                    .codigo(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .mensagem(violations)
                    .build();
        } else {
            String message = e.getMessage();
            log.error(message, e);
            errorDTO = ErrorDTO.builder()
                    .codigo(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .mensagem(message)
                    .build();
        }
        return errorDTO;
    }

    private String extractViolationFromException(ConstraintViolationException e) {
        return e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("--"));

    }
}
