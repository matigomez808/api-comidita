package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends RepoBase<Usuario, Long>{

    UserDetails findByLogin(String login);
}