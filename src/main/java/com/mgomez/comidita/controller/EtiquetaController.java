package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.records.etiqueta.AddEtiqueta;
import com.mgomez.comidita.domain.records.etiqueta.DatosEtiqueta;
import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import com.mgomez.comidita.servicios.EtiquetaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/etiquetas")
public class EtiquetaController {

    @Autowired
    private EtiquetaServicio etiquetaServicio;

    @PostMapping
    public ResponseEntity agregarTag(@RequestBody @Valid AddEtiqueta data) {
        etiquetaServicio.guardarEtiquetaNueva(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Etiqueta> listarTags(@PageableDefault(size = 10) Pageable pageable) {
        return etiquetaServicio.listarEtiquetasActivas();
    }

    // Modificar tag

    // Eliminar tag

}
