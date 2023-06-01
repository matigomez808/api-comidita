package com.mgomez.comidita.domain.records.ingrediente;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.models.Ingrediente;

import java.util.List;

public record ListarIngredientes(Long id,
                                 String nombre,
                                 String descripcion,
                                 List<Etiqueta> listaEtiquetas

) {
    public ListarIngredientes(Ingrediente ingrediente){
        this(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getDescripcion(), ingrediente.getListaEtiquetasIngrediente());
    }
}
