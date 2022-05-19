package com.br.gatravesso.app.controller;

import com.br.gatravesso.app.response.BaseResponse;

public class BaseController {

    private BaseResponse response;

    public BaseController(){
        response.message = "Erro, contate o administrador";
        response.statusCode = 500;
    }
}
