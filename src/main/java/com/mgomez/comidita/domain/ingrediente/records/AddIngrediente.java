package com.mgomez.comidita.domain.ingrediente.records;

import jakarta.validation.constraints.NotBlank;

public record AddIngrediente(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion
) {
}
