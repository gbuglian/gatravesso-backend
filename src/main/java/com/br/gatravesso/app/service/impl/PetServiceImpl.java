package com.br.gatravesso.app.service.impl;

import com.br.gatravesso.app.mapper.PetMapper;
import com.br.gatravesso.app.model.Pet;
import com.br.gatravesso.app.mysql.mapper.PetEntityMapper;
import com.br.gatravesso.app.mysql.repository.PetRepository;
import com.br.gatravesso.app.request.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl {

    private final PetRepository repository;
    private final PetEntityMapper entityMapper;
    private final PetMapper mapper;


    public Pet criaPet(PetDTO dto) {
        return mapper.toModel(repository.save(entityMapper.toEntiy(dto)));
    }

    public Pet buscaPet(Long idPet) {
        var result  = repository.findById(idPet);
       if (result.isPresent()){
           return mapper.toModel(result.get());
       }
        else
            throw new IllegalArgumentException("Pet não encontrado");

    }

    public List<Pet> buscaTodosPet() {

        var result = repository.buscaTodosDisponiveis();
        if (!result.isEmpty()){
            return mapper.toModelList(result);
        }

        return Collections.emptyList();
    }
}
