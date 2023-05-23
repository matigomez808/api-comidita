package com.mgomez.comidita.domain.receta;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.tag.Etiqueta;

import java.util.List;

public record DatosListarReceta(
        Long id,
        String nombre,
        String descripcion,
        List<Ingrediente> listaIngredientes

) {
    public DatosListarReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion(), receta.getListaIngredientes());
    }
}
