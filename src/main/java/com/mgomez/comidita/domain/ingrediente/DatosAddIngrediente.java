package com.mgomez.comidita.domain.ingrediente;

import jakarta.validation.constraints.NotBlank;

public record DatosAddIngrediente(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion
) {
}
