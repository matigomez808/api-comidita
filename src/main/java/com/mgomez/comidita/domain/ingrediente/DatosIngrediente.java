package com.mgomez.comidita.domain.ingrediente;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.tag.Etiqueta;

import java.util.List;

public record DatosIngrediente(
        Long id,
        String nombre,
        String descripcion,
        List<Etiqueta> listaEtiquetas
) {
    public DatosIngrediente(Ingrediente ingrediente) {
        this(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getDescripcion(),ingrediente.getListaEtiquetas());
    }
}
