package com.mgomez.comidita.domain.etiqueta.records;

import jakarta.validation.constraints.NotBlank;

public record AddEtiqueta(
        @NotBlank
        String nombre
) {
}
