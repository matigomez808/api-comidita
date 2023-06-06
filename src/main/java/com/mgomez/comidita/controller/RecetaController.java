package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.models.Receta;
import com.mgomez.comidita.domain.records.receta.AddReceta;
import com.mgomez.comidita.domain.records.receta.DatosReceta;
import com.mgomez.comidita.domain.records.receta.EtiquetarReceta;
import com.mgomez.comidita.domain.records.receta.ListarReceta;
import com.mgomez.comidita.servicios.RecetaServicio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private RecetaServicio recetaServicio;


    @GetMapping
    public List<Receta> listarRecetas() {
        return recetaServicio.listaRecetasActivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosReceta> mostrarRecetaPorID(@PathVariable Long id) {
        Receta receta = recetaServicio.encontrarPorId(id);
        return ResponseEntity.ok(armarRespuesta(receta));
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarReceta(@RequestBody @Valid AddReceta addReceta, UriComponentsBuilder uriComponentsBuilder) {
        Receta receta = recetaServicio.guardarRecetaNueva(addReceta);
        URI url = uriComponentsBuilder.path("/receta/{id}").buildAndExpand(receta.getId()).toUri();
        return ResponseEntity.created(url).body(armarRespuesta(receta));
    }

    @PostMapping("/etiquetar")
    @Transactional
    public ResponseEntity etiquetarReceta(@RequestBody @Valid EtiquetarReceta etiquetasReceta) {
        Receta receta = recetaServicio.encontrarPorId(etiquetasReceta.idReceta());
        receta = recetaServicio.etiquetarReceta(etiquetasReceta);
        return ResponseEntity.ok("Etiquetado con éxito");
    }

    @PostMapping("/eliminar")
    @Transactional
    public ResponseEntity eliminarReceta(@RequestBody @Valid Long id) {
        recetaServicio.eliminarActivo(id);
        return ResponseEntity.noContent().build();
    }

    public DatosReceta armarRespuesta(Receta r) {
        DatosReceta rta = new DatosReceta(
                r.getId(), r.getNombre(), r.getDescripcion(), r.getInstrucciones(),r.getListaIngredientes(),r.getListaEtiquetasReceta(), r.isActivo());
        return rta;
    }
}
