package com.cfrdocarmo.cfrdocarmofood.auth.core;

import com.cfrdocarmo.cfrdocarmofood.auth.domain.Usuario;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class AuthUser extends User {

    private String fullName;

    public AuthUser(Usuario usuario) {
        super(usuario.getEmail(), usuario.getSenha(), Collections.emptyList());

        this.fullName = usuario.getNome();
    }

}
