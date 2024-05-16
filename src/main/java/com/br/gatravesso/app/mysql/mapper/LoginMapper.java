package com.br.gatravesso.app.mysql.mapper;

import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.mysql.entity.LoginEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    List<Login> toModel (List<LoginEntity> entity);

    LoginEntity ToEntity (Login model);

    Login ToModel (LoginEntity entity);
}

