package com.mgomez.comidita.domain.records.usuario;

import jakarta.validation.constraints.NotBlank;

public record RegistrarUsuario(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotBlank
        String email
) {
}
