package com.mgomez.comidita.domain.receta.records;

import com.mgomez.comidita.domain.etiqueta.Etiqueta;

import java.util.List;

public record EtiquetarReceta(
        Long idReceta,
        List<Etiqueta> listaEtiquetas
) {
}
