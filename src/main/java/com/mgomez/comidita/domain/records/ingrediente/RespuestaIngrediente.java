package com.mgomez.comidita.domain.records.ingrediente;

import com.mgomez.comidita.domain.models.Ingrediente;

public record RespuestaIngrediente(
        Long id,
        String nombre,
        String descripcion,
        String gondola
) {


}
