package com.mgomez.comidita.domain.ingrediente;

import com.mgomez.comidita.domain.tag.Etiqueta;

import java.util.List;

public record DatosEtiquetarIngrediente(
        Long idIngrediente,
        List<Etiqueta> etiquetas

) {
}
