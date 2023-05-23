package com.mgomez.comidita.domain.receta;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.tag.Etiqueta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
