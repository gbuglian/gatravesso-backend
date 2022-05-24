package com.br.gatravesso.app.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_PET")
@NoArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    private String nomePet;

    private Long idade;

    private String sexo;

    private String descricaoPet;

    private Character disponivelAdocao;
}




