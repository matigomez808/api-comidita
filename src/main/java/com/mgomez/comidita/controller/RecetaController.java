package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.receta.*;
import com.mgomez.comidita.domain.receta.DatosAddReceta;
import com.mgomez.comidita.domain.tag.EtiquetaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private EtiquetaRepository tagRepository;

    @PostMapping
    public ResponseEntity agregarReceta(
            @RequestBody @Valid
            DatosAddReceta datosAddReceta) {
        Receta receta = recetaRepository.save(new Receta(datosAddReceta));
        return ResponseEntity.ok(receta.toString());
    }

    @PostMapping("/etiquetar")
    @Transactional
    public void etiquetarReceta(
            @RequestBody @Valid
            DatosEtiquetarReceta datosEtiquetarReceta) {
        Receta receta = recetaRepository.getReferenceById(datosEtiquetarReceta.idReceta());
        receta.etiquetar(datosEtiquetarReceta.listaEtiquetas());
        recetaRepository.saveAndFlush(receta);


    }

    @GetMapping
    public ResponseEntity<Page<DatosListarReceta>> listarRecetas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(recetaRepository.findAll(pageable).map(DatosListarReceta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosReceta> mostrarRecetaPorID(@PathVariable Long id) {
        Receta receta = recetaRepository.getReferenceById(id);
        DatosReceta datosReceta = new DatosReceta(receta);
        return ResponseEntity.ok(datosReceta);
    }


}
