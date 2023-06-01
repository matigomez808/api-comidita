package com.mgomez.comidita.domain.records.etiqueta;

import jakarta.validation.constraints.NotBlank;

public record AddEtiqueta(
        @NotBlank
        String nombre
) {
}
