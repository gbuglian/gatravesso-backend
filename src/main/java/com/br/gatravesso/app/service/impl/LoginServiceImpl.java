package com.br.gatravesso.app.service.impl;

import com.br.gatravesso.app.exception.CustomHandlerException;
import com.br.gatravesso.app.exception.ErrorWarningMensagemException;
import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.mysql.entity.LoginEntity;
import com.br.gatravesso.app.mysql.mapper.LoginMapper;
import com.br.gatravesso.app.mysql.mapper.PetEntityMapper;
import com.br.gatravesso.app.mysql.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl {

    private final LoginRepository loginRepository;
    private final LoginMapper mapper;

    public String salvaUsuario (Login login) throws Exception {

        var consulta = loginRepository.findByUsuario(login.getUsuario());

       if (Objects.nonNull(consulta)){
               throw new ErrorWarningMensagemException("001", "Usuário já cadastrado");
        }
        loginRepository.save(mapper.ToEntity(login));
       return "redirect:/";
    }

    public Login buscaUsuario (String login){
        return mapper.ToModel(loginRepository.findByUsuario(login));
    }


    public List<Login> buscaUsuarios (){

        Iterable<LoginEntity> iterable = loginRepository.findAll();
        List<LoginEntity> result = new ArrayList<>();

        iterable.forEach(result::add);

        return mapper.toModel(result);
    }

}
