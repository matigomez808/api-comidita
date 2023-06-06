package com.mgomez.comidita.domain.records.receta;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.models.IngredienteReceta;
import com.mgomez.comidita.domain.models.Receta;

import java.util.List;

public record DatosReceta(
        Long id,
        String nombre,
        String descripcion,
        String instrucciones,
        List<IngredienteReceta> listaIngredientes,
        List<Etiqueta> listaEtiquetasReceta,
        boolean activo
) {
    public DatosReceta(Receta receta) {
        this(receta.getId(), receta.getNombre(), receta.getDescripcion(), receta.getInstrucciones(), receta.getListaIngredientes(), receta.getListaEtiquetasReceta(), receta.isActivo());
    }
}
