package com.br.gatravesso.app.mysql.mapper;

import com.br.gatravesso.app.model.Pet;
import com.br.gatravesso.app.mysql.entity.PetEntity;
import com.br.gatravesso.app.request.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetEntityMapper {

    @Mappings({
            @Mapping(source = "idPet", target = "idPet"),
            @Mapping(source = "nomePet", target = "nomePet"),
            @Mapping(source = "idade", target = "idade"),
            @Mapping(source = "sexo", target = "sexo")

    })
    PetEntity toEntiy (PetDTO dto);
}
