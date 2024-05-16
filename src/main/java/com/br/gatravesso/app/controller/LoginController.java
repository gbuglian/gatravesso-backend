package com.br.gatravesso.app.controller;

import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.request.LoginDTO;
import com.br.gatravesso.app.request.mapper.LoginDTOMapper;
import com.br.gatravesso.app.service.impl.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginService;
    private final PasswordEncoder encoder;
    private final LoginDTOMapper mapper;

    @PostMapping(value = "/criaLogin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void salvarUsuario(@RequestBody LoginDTO login) throws Exception {
        login.setSenha(encoder.encode(login.getSenha()));
        loginService.salvaUsuario(mapper.ToModel(login));
    }

    @GetMapping(value = "/buscaLogin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Login>> buscarTodos() {

        return ResponseEntity.ok(loginService.buscaUsuarios());
    }

    @PostMapping (value = "/validarSenha",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> validarSenha(@RequestBody LoginDTO login){

       Login optLogin = loginService.buscaUsuario(login.getUsuario());

        if (Objects.isNull(optLogin)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = encoder.matches(login.getSenha(), optLogin.getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
