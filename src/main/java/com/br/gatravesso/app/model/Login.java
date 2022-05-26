package com.br.gatravesso.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {

    private String userId;
    private String usuario;
    private String senha;
}
