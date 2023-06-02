package com.mgomez.comidita.domain.records.ingredienteReceta;

import com.mgomez.comidita.domain.records.ingrediente.Unidad;

public record RecetaIngredienteDTO(Long id,
                                   Unidad unidad,
                                   Integer cantidad) {
}
