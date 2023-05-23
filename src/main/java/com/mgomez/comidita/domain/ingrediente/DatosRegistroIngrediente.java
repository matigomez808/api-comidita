package com.mgomez.comidita.domain.ingrediente;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;

public record DatosRegistroIngrediente(
        Long id,
        String nombre,
        String descpripcion
) {
    public DatosRegistroIngrediente(Ingrediente ingrediente){
        this(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getDescripcion());
    }
}
