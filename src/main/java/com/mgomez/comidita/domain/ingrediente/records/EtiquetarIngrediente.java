package com.mgomez.comidita.domain.ingrediente.records;

import com.mgomez.comidita.domain.etiqueta.Etiqueta;

import java.util.List;

public record EtiquetarIngrediente(
        Long idIngrediente,
        List<Etiqueta> etiquetas

) {
}
