package com.mgomez.comidita.domain.ingrediente.records;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;

public record RegistroIngrediente(
        Long id,
        String nombre,
        String descpripcion
) {
    public RegistroIngrediente(Ingrediente ingrediente){
        this(ingrediente.getId(), ingrediente.getNombre(), ingrediente.getDescripcion());
    }
}
