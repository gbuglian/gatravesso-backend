package com.br.gatravesso.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Publicacao {

    private Long idPublicacao;
//    private Image fotoPet;
    private String textoPublicacao;
    private Long visualizacao;
    private Long idPet;

}
