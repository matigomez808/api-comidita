package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.records.ingrediente.AddIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.EtiquetarIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.RespuestaIngrediente;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import com.mgomez.comidita.domain.records.ingrediente.ListarIngredientes;
import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.repos.IngredienteRepository;
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

    @GetMapping
    public ResponseEntity<Page<ListarIngredientes>> listarIngredientes(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(ingredienteRepository.findByActivoTrue(pageable).map(ListarIngredientes::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaIngrediente> mostrarIngredientePorID(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(id);
        var respuestaIngrediente = new RespuestaIngrediente(
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getDescripcion(),
                ingrediente.getGondola().toString());
        return ResponseEntity.ok(respuestaIngrediente);
    }

    @PostMapping
    public ResponseEntity agregarIngediente(@RequestBody @Valid AddIngrediente datosIngrediente, UriComponentsBuilder uriComponentsBuilder) {
        Ingrediente ingrediente = ingredienteRepository.save(new Ingrediente(datosIngrediente));
        RespuestaIngrediente respuestaIngrediente = new RespuestaIngrediente(
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getDescripcion(),
                ingrediente.getGondola().toString());
        URI url = uriComponentsBuilder.path("/ingrediente/{id}").buildAndExpand(ingrediente.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaIngrediente);
    }

    @PostMapping("/etiquetar")
    @Transactional
    public ResponseEntity etiquetarIngrediente(@RequestBody @Valid EtiquetarIngrediente datosTagIngrediente) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(datosTagIngrediente.idIngrediente());
        ingrediente.etiquetar(datosTagIngrediente.etiquetas());
        System.out.println(ingrediente.getNombre());
        ingredienteRepository.saveAndFlush(ingrediente);
        return ResponseEntity.ok("Etiquetado con éxito");


    }

    @PostMapping("/eliminar")
    @Transactional
    public ResponseEntity eliminarIngrediente(@RequestBody @Valid Long id) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(id);
        ingrediente.desactivar();
        ingredienteRepository.saveAndFlush(ingrediente);
        return ResponseEntity.noContent().build();
    }



}
