package com.mgomez.comidita.domain.tag;

public record DatosEtiqueta(
        Long id,
        String nombre) {

    public DatosEtiqueta(Etiqueta tag) {
        this(tag.getId(), tag.getNombre());

    }
}
