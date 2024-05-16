//package com.br.gatravesso.app.service.jwt.security;
//
//import com.br.gatravesso.app.service.impl.DetalheUsuarioServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@RequiredArgsConstructor
//@EnableWebSecurity
//public class JWTConfig extends WebSecurityConfigurerAdapter {
//
//    private final DetalheUsuarioServiceImpl detalheUsuarioService;
//    private final PasswordEncoder encoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(detalheUsuarioService).passwordEncoder(encoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().addFilter(new JWTAutenticarFilter(authenticationManager()))
//                .addFilter(new JWTValidaFilter(authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//
//    @Bean
//    CorsConfigurationSource corsConfiguration() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }
//}
