package com.mgomez.comidita.domain.records.receta;

import com.mgomez.comidita.domain.models.Receta;

public record ListarReceta(
        Long id,
        String nombre,
        String descripcion

) {
    public ListarReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion());
    }
}
