package com.br.gatravesso.app.mapper;

import com.br.gatravesso.app.model.Pet;
import com.br.gatravesso.app.mysql.entity.PetEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toModel (PetEntity entity);

    List<Pet> toModelList (List<PetEntity> entity);

}
