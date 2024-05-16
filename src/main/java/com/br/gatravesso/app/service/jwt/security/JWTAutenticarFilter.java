//package com.br.gatravesso.app.service.jwt.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.br.gatravesso.app.model.Login;
//import com.br.gatravesso.app.request.LoginDTO;
//import com.br.gatravesso.app.service.jwt.DetalheUsuarioData;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//@RequiredArgsConstructor
//public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
//
//    public static final int TOKEN_EXPIRACAO = 600_000;
//    public static final String TOKEN_SENHA = "3c5aa351-a568-439d-bc74-37b6a378fc8d";
//    private final AuthenticationManager authenticationManager;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        try {
//            LoginDTO login = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
//
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    login.getUsuario(),
//                    login.getSenha(),
//                    new ArrayList<>()
//            ));
//        } catch (IOException e) {
//            throw new RuntimeException("Falha ao autenticar usuário", e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//
//        DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
//
//        String token = JWT.create()
//                .withSubject(usuarioData.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
//                .sign(Algorithm.HMAC512(TOKEN_SENHA));
//
//        response.getWriter().write(token);
//        response.getWriter().flush();
//
//    }
//}
