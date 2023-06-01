package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.models.Receta;
import com.mgomez.comidita.domain.records.receta.AddReceta;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import com.mgomez.comidita.domain.records.receta.EtiquetarReceta;
import com.mgomez.comidita.domain.records.receta.ListarReceta;
import com.mgomez.comidita.domain.records.receta.DatosReceta;
import com.mgomez.comidita.domain.repos.RecetaRepository;
import com.mgomez.comidita.domain.repos.IngredienteRecetaRepository;
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


    @GetMapping
    public ResponseEntity<Page<ListarReceta>> listarRecetas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(recetaRepository.findByActivoTrue(pageable).map(ListarReceta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosReceta> mostrarRecetaPorID(@PathVariable Long id) {
        Receta receta = recetaRepository.getReferenceById(id);
        DatosReceta datosReceta = new DatosReceta(receta);
        return ResponseEntity.ok(datosReceta);
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarReceta(@RequestBody @Valid AddReceta addReceta) {
        Receta receta = recetaRepository.save(new Receta(addReceta));
        return ResponseEntity.ok(new DatosReceta(receta));
    }

    @PostMapping("/etiquetar")
    @Transactional
    public void etiquetarReceta(@RequestBody @Valid EtiquetarReceta datosEtiquetarReceta) {
        Receta receta = recetaRepository.getReferenceById(datosEtiquetarReceta.idReceta());
        receta.etiquetar(datosEtiquetarReceta.listaEtiquetas());
        recetaRepository.saveAndFlush(receta);


    }

    @PostMapping("/eliminar")
    @Transactional
    public ResponseEntity eliminarReceta(@RequestBody @Valid Long id) {
        Receta receta = recetaRepository.getReferenceById(id);
        receta.desactivar();
        recetaRepository.saveAndFlush(receta);
        return ResponseEntity.noContent().build();

    }
}
