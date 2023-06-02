package com.mgomez.comidita.domain.records.receta;

import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.models.IngredienteReceta;
import com.mgomez.comidita.domain.models.Receta;

import java.util.List;

public record ListarReceta(
        Long id,
        String nombre,
        String descripcion

) {
    public ListarReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion());
    }
}
