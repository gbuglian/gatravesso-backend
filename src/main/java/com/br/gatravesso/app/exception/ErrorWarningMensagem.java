package com.br.gatravesso.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorWarningMensagem implements Serializable {

    private String codigo;
    private String mensagem;

}
