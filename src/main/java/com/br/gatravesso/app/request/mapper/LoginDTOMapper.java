package com.br.gatravesso.app.request.mapper;


import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.request.LoginDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginDTOMapper {

    Login ToModel(LoginDTO dto);

    LoginDTO ToDTO(Login model);

}
