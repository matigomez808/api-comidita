package com.mgomez.comidita.domain.receta.records;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.etiqueta.Etiqueta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddReceta(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotBlank
        String instrucciones,
        @NotNull
        List<Ingrediente> listaIngredientes,
        List<Etiqueta> listaEtiquetas
) {
}
