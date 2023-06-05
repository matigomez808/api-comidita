package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.records.ingrediente.AddIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.EtiquetarIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.RespuestaIngrediente;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import com.mgomez.comidita.domain.records.ingrediente.ListarIngredientes;
import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.repos.IngredienteRepository;
import com.mgomez.comidita.servicios.IngredienteServicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private EtiquetaRepository tagRepository;
    @Autowired
    IngredienteServicio ingredienteServicio;

    @GetMapping
    public ResponseEntity<Page<ListarIngredientes>> listarIngredientes(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(ingredienteRepository.findByActivoTrue(pageable).map(ListarIngredientes::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaIngrediente> mostrarIngredientePorID(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteServicio.findByID(id);
        return ResponseEntity.ok(armarRespuestaIngrediente(ingrediente));
    }

    @PostMapping
    public ResponseEntity agregarIngediente(@RequestBody @Valid AddIngrediente addIngrediente, UriComponentsBuilder uriComponentsBuilder) {
        Ingrediente ingrediente = ingredienteServicio.guardarIngredienteNuevo(addIngrediente);
        URI url = uriComponentsBuilder.path("/ingrediente/{id}").buildAndExpand(ingrediente.getId()).toUri();
        return ResponseEntity.created(url).body(armarRespuestaIngrediente(ingrediente));
    }

    @PostMapping("/etiquetar")
    @Transactional
    public ResponseEntity etiquetarIngrediente(@RequestBody @Valid EtiquetarIngrediente etiquetasIngrediente) {
        Ingrediente ingrediente = ingredienteServicio.findByID(etiquetasIngrediente.idIngrediente());
        ingrediente = ingredienteServicio.etiquetarIngrediente(etiquetasIngrediente);
        return ResponseEntity.ok("Etiquetado con éxito");
    }

    @PostMapping("/eliminar")
    @Transactional
    public ResponseEntity eliminarIngrediente(@RequestBody @Valid Long id) {
        ingredienteServicio.eliminarActivo(id);
        return ResponseEntity.noContent().build();
    }

    public RespuestaIngrediente armarRespuestaIngrediente(Ingrediente i) {
        RespuestaIngrediente rta = new RespuestaIngrediente(
                i.getId(), i.getNombre(), i.getDescripcion(), i.getGondola().toString());
        return rta;
    }

}
