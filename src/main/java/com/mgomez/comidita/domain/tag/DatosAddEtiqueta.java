package com.mgomez.comidita.domain.tag;

import jakarta.validation.constraints.NotBlank;

public record DatosAddEtiqueta(
        @NotBlank
        String nombre
) {
}
