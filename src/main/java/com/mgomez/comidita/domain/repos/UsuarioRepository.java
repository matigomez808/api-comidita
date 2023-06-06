package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends RepoBase<Usuario, Long>{
    UserDetails findByUsername(String username);
}