package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepository usuarioRepository;



}
