package com.cfrdocarmo.cfrdocarmofood.auth.core;

import com.cfrdocarmo.cfrdocarmofood.auth.domain.Usuario;
import com.cfrdocarmo.cfrdocarmofood.auth.domain.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    public static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado com o e-mail informado.";
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow( () -> new UsernameNotFoundException(USUARIO_NAO_ENCONTRADO));

        return new AuthUser(usuario);
    }
}
