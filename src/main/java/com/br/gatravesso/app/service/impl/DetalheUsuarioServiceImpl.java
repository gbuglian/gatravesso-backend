//package com.br.gatravesso.app.service.impl;
//
//import com.br.gatravesso.app.request.mapper.LoginDTOMapper;
//import com.br.gatravesso.app.service.jwt.DetalheUsuarioData;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class DetalheUsuarioServiceImpl implements UserDetailsService {
//
//    private final LoginServiceImpl impl;
//    private final LoginDTOMapper mapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var opt = Optional.of(impl.buscaUsuario(username));
//
//        if (opt.isEmpty()){
//            throw new UsernameNotFoundException("Usuário [" + username +"] não encontrado");
//        }
//
//        return new DetalheUsuarioData(mapper.ToDTO(opt.get()));
//    }
//}
