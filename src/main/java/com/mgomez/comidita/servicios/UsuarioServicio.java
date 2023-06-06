package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.models.Usuario;
import com.mgomez.comidita.domain.records.usuario.RegistrarUsuario;
import com.mgomez.comidita.domain.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrarUsuario(RegistrarUsuario datos){
        Usuario usuario = new Usuario();
        String login = datos.login();
        String email = datos.email();
        String pass = passwordEncoder.encode(datos.pass());
        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username);
    }
}
