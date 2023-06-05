package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByLogin(String username);
}