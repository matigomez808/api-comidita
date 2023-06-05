package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.models.Usuario;
import com.mgomez.comidita.domain.records.usuario.DatosAutenticarUsuario;
import com.mgomez.comidita.domain.repos.UsuarioRepository;
import com.mgomez.comidita.infra.security.TokenService;
import com.mgomez.comidita.infra.security.records.DatosJWTToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity autenticarUsuario(
            @RequestBody @Valid
            DatosAutenticarUsuario datosAutenticarUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticarUsuario.login(),
                datosAutenticarUsuario.pass());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));

    }


}
