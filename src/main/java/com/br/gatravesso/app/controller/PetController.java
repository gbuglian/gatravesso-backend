package com.br.gatravesso.app.controller;

import com.br.gatravesso.app.request.PetDTO;
import com.br.gatravesso.app.request.mapper.PetDTOMapper;
import com.br.gatravesso.app.service.impl.PetServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetServiceImpl petService;
    private final PetDTOMapper dtoMapper;

    @PostMapping(
            value = "/salvar_pet",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetDTO> salvarPet (@Valid @RequestBody PetDTO dto){
        return ResponseEntity.ok(this.dtoMapper.toDTO(this.petService.criaPet(dto)));
    }

    @GetMapping(
            value = "/busca_pet/{id_pet}",
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetDTO> buscaPet (@PathVariable(name = "id_pet") Long idPet){
        return ResponseEntity.ok(dtoMapper.toDTO(petService.buscaPet(idPet)));
    }

    @GetMapping(
            value = "/bsuca_pet",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PetDTO>> buscaTodosPet (){
        return ResponseEntity.ok(dtoMapper.toDtoList(petService.buscaTodosPet()));
    }



    public PetController(PetServiceImpl petService, PetDTOMapper dtoMapper) {
        this.petService = petService;
        this.dtoMapper = dtoMapper;
    }
}
