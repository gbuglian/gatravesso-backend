//package com.br.gatravesso.app.service.jwt.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Objects;
//
//public class JWTValidaFilter extends BasicAuthenticationFilter {
//
//    public static final String HEADER_ATRIBUTO = "Authorization";
//    public static final String ATRIBUTO_PREFIXO = "Bearer ";
//
//    public JWTValidaFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        String atributo = request.getHeader(HEADER_ATRIBUTO);
//
//        if (Objects.isNull(atributo) || !atributo.startsWith(ATRIBUTO_PREFIXO) ){
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//                getAuthenticationToken(atributo.replace(ATRIBUTO_PREFIXO, ""));
//
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request, response);
//
//    }
//
//    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
//        String login = JWT.require(Algorithm.HMAC512(JWTAutenticarFilter.TOKEN_SENHA))
//                .build()
//                .verify(token)
//                .getSubject();
//
//        return Objects.isNull(login) ? null
//                : new UsernamePasswordAuthenticationToken
//                (login, null, new ArrayList<>());
//    }
//}
