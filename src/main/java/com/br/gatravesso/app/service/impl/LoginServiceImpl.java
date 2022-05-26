package com.br.gatravesso.app.service.impl;

import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.mysql.entity.LoginEntity;
import com.br.gatravesso.app.mysql.mapper.LoginMapper;
import com.br.gatravesso.app.mysql.mapper.PetEntityMapper;
import com.br.gatravesso.app.mysql.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl {

    private final LoginRepository loginRepository;
    private final LoginMapper mapper;

    public Login salvaUsuario (Login login) {

        var consulta = loginRepository.findByUsuario(login.getUsuario());

       if (Objects.nonNull(consulta)){
            throw new IllegalArgumentException();
        }

        return mapper.ToModel(loginRepository.save(mapper.ToEntity(login)));

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
