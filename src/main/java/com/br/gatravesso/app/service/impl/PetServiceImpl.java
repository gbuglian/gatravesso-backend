package com.br.gatravesso.app.service.impl;

import com.br.gatravesso.app.mapper.PetMapper;
import com.br.gatravesso.app.model.Pet;
import com.br.gatravesso.app.mysql.mapper.PetEntityMapper;
import com.br.gatravesso.app.mysql.repository.PetRepository;
import com.br.gatravesso.app.request.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PetServiceImpl {

    private final PetRepository repository;
    private final PetEntityMapper entityMapper;
    private final PetMapper mapper;

    public PetServiceImpl(PetRepository repository, PetEntityMapper entityMapper, PetMapper mapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
        this.mapper = mapper;
    }


    public Pet criaPet(PetDTO dto) {
        return mapper.toModel(repository.save(entityMapper.toEntiy(dto)));
    }

    public Pet buscaPet(Long idPet) {

       if (repository.findById(idPet).isPresent()){
           return mapper.toModel(repository.findById(idPet).get());
       }
        else
            throw new IllegalArgumentException("Pet não encontrado");

    }

    public List<Pet> buscaTodosPet() {

        if (!repository.findAll().isEmpty()){
            return mapper.toModelList(repository.findAll());
        }

        return Collections.emptyList();
    }
}
