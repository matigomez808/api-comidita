package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.ingrediente.*;
import com.mgomez.comidita.domain.ingrediente.records.AddIngrediente;
import com.mgomez.comidita.domain.ingrediente.records.EtiquetarIngrediente;
import com.mgomez.comidita.domain.ingrediente.records.DatosIngrediente;
import com.mgomez.comidita.domain.ingrediente.records.RegistroIngrediente;
import com.mgomez.comidita.domain.etiqueta.EtiquetaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private EtiquetaRepository tagRepository;

    @GetMapping
    public ResponseEntity<Page<RegistroIngrediente>> listarIngredientes(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(ingredienteRepository.findByActivoTrue(pageable).map(RegistroIngrediente::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosIngrediente> mostrarIngredientePorID(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(id);
        DatosIngrediente datosIngrediente = new DatosIngrediente(ingrediente);
        return ResponseEntity.ok(datosIngrediente);
    }

    @PostMapping
    public ResponseEntity agregarIngediente(@RequestBody @Valid AddIngrediente datosIngrediente) {
        Ingrediente ingrediente = ingredienteRepository.save(new Ingrediente(datosIngrediente));
        return ResponseEntity.ok(ingrediente.toString());
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
