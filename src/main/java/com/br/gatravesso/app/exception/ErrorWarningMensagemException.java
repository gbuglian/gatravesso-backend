package com.br.gatravesso.app.exception;


import lombok.Getter;

import java.io.Serializable;

@Getter
public class ErrorWarningMensagemException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -526298575805251598L;

    private final ErrorWarningMensagem errorWarningMensagem;

    public ErrorWarningMensagemException(String codigo, String message){
        super(message);
        this.errorWarningMensagem = new ErrorWarningMensagem(codigo, message);
    }


}
