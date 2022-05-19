package com.br.gatravesso.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pet {

    private Long idPet;
    private String nomePet;
    private Long idade;
    private String sexo;

}
