package com.mgomez.comidita.domain.records.etiqueta;

import com.mgomez.comidita.domain.models.Etiqueta;

public record DatosEtiqueta(
        Long id,
        String nombre) {

    public DatosEtiqueta(Etiqueta tag) {
        this(tag.getId(), tag.getNombre());

    }
}
