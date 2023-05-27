package com.mgomez.comidita.domain.receta.records;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.etiqueta.Etiqueta;
import com.mgomez.comidita.domain.receta.Receta;

import java.util.List;

public record DatosReceta(
        Long id,
        String nombre,
        String descripcion,
        String instrucciones,
        List<Ingrediente> listaIngredientes,
        List<Etiqueta> listaEtiquetas
) {
    public DatosReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion(), receta.getInstrucciones(), receta.getListaIngredientes(), receta.getListaEtiquetas());
    }
}
