package com.br.gatravesso.app.service.jwt;

import com.br.gatravesso.app.model.Login;
import com.br.gatravesso.app.request.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public class DetalheUsuarioData implements UserDetails {

    private final LoginDTO login;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        var opt = Optional.of(login);
        return opt.orElse(new LoginDTO()).getSenha();
    }

    @Override
    public String getUsername() {
        var opt = Optional.of(login);
        return opt.orElse(new LoginDTO()).getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
