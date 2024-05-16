package com.br.gatravesso.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource source;

    @ExceptionHandler(ErrorWarningMensagemException.class)
    public ResponseEntity<Object> methodArgumentTypeMismatchException(ErrorWarningMensagemException ex){
        return ResponseEntity.badRequest().body(ex.getErrorWarningMensagem());
    }

}
