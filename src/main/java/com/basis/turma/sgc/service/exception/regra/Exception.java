package com.basis.turma.sgc.service.exception.regra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Exception extends RuntimeException {

    public Exception(final String mensagem) {
        this(mensagem, null);
    }

    public Exception(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }
}
