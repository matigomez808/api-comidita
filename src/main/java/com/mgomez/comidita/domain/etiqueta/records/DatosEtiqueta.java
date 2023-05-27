package com.mgomez.comidita.domain.etiqueta.records;

import com.mgomez.comidita.domain.etiqueta.Etiqueta;

public record DatosEtiqueta(
        Long id,
        String nombre) {

    public DatosEtiqueta(Etiqueta tag) {
        this(tag.getId(), tag.getNombre());

    }
}
