package com.mgomez.comidita.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mgomez.comidita.domain.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("comidita")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null)
            throw new RuntimeException();
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("comidita")
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException(exception.toString());
        }
        if (verifier.getSubject() == null)
            throw new RuntimeException("Verifier invalido");
        return verifier.getSubject();
    }

    private Instant generarFechasExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-5:00"));
    }
}
