package com.br.gatravesso.app.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "TB_PUBLICACAO")
public class PublicacaoEntity {

    @EmbeddedId
    private Long idPublicacao;

//    private Image fotoPet;

    private String textoPet;

    private Long visualizacao;

    @ManyToOne
    @JoinColumn(name = "petEntity")
    private PetEntity petEntity;
}
