package com.br.gatravesso.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PetDTO {

    @JsonProperty
    private Long idPet;

    @NotNull(message = "Nome pet não pode ser nulo")
    @NotEmpty(message = "Nome pet não pode ser vazio")
    @JsonProperty
    private String nomePet;

    @NotNull(message = "Idade não pode ser nulo")
    @JsonProperty
    private Long idade;

    @NotNull(message = "Sexo não pode ser nulo")
    @Pattern(regexp = "([F|M])", message = "Valores aceitos F|M")
    @JsonProperty
    private String sexo;

    @NotNull(message = "Descrição do Pet é obrigatória")
    private String descricaoPet;

    @NotNull(message = "Informe disponibilidade")
    @Pattern(regexp = "([S|N])", message = "Valores aceitos S|N")
    private String disponivelAdocao;
}
