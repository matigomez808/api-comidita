package com.mgomez.comidita.domain.records.ingrediente;

import com.mgomez.comidita.domain.models.Etiqueta;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AddIngrediente(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        List<Etiqueta> listaEtiquetas,
        Gondola gondola

) {
}
