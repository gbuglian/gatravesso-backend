package com.br.gatravesso.app.model;

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
