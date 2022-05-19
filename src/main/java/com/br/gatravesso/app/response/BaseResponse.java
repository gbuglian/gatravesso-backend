package com.br.gatravesso.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {

    @Transient
    public int statusCode;

    @Transient
    public String message;

}
