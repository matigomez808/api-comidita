package com.mgomez.comidita.domain.records.receta;

import com.mgomez.comidita.domain.models.Etiqueta;

import java.util.List;

public record EtiquetarReceta(
        Long idReceta,
        List<Etiqueta> etiquetas
) {
}
