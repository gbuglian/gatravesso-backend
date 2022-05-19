package com.br.gatravesso.app.request.mapper;

import com.br.gatravesso.app.model.Pet;
import com.br.gatravesso.app.request.PetDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetDTOMapper {

    PetDTO toDTO (Pet model);

    List<PetDTO> toDtoList (List<Pet> modelList);

}
