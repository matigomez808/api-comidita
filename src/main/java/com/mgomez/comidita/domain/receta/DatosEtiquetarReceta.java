package com.mgomez.comidita.domain.receta;

import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.tag.Etiqueta;

import java.util.List;

public record DatosEtiquetarReceta(
        Long idReceta,
        List<Etiqueta> listaEtiquetas
) {
}
