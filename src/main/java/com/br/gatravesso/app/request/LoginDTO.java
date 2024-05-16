package com.br.gatravesso.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LoginDTO {

    @JsonProperty
    private String usuario;

    @JsonProperty
    private String senha;

}
