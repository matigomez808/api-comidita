package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.tag.DatosAddEtiqueta;
import com.mgomez.comidita.domain.tag.DatosEtiqueta;
import com.mgomez.comidita.domain.tag.Etiqueta;
import com.mgomez.comidita.domain.tag.EtiquetaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/tags")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository tagRepository;

    @PostMapping
    public ResponseEntity agregarTag(
            @RequestBody @Valid
            DatosAddEtiqueta datosAddTag) {
        Etiqueta tag = tagRepository.save(new Etiqueta(datosAddTag));
        System.out.println(tag.getId() + tag.getNombre());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DatosEtiqueta>> listarTags(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(tagRepository.findAll(pageable).map(DatosEtiqueta::new));
    }

//    @GetMapping
//    public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
//        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
//        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));
//    }

}
