package com.mgomez.comidita.domain.records.receta;

import com.mgomez.comidita.domain.models.IngredienteReceta;
import com.mgomez.comidita.domain.models.Etiqueta;
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
        List<IngredienteReceta> listaIngredientesConCantidad,
        List<Etiqueta> listaEtiquetas

) {
}
