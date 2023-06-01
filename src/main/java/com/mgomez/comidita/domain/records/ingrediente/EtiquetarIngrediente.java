package com.mgomez.comidita.domain.records.ingrediente;

import com.mgomez.comidita.domain.models.Etiqueta;

import java.util.List;

public record EtiquetarIngrediente(
        Long idIngrediente,
        List<Etiqueta> etiquetas

) {
}
