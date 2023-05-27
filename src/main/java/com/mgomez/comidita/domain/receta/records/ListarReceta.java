package com.mgomez.comidita.domain.receta.records;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.receta.Receta;

import java.util.List;

public record ListarReceta(
        Long id,
        String nombre,
        String descripcion,
        List<Ingrediente> listaIngredientes

) {
    public ListarReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion(), receta.getListaIngredientes());
    }
}
