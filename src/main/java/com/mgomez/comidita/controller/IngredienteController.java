package com.mgomez.comidita.controller;

import com.mgomez.comidita.domain.ingrediente.*;
import com.mgomez.comidita.domain.ingrediente.DatosEtiquetarIngrediente;
import com.mgomez.comidita.domain.ingrediente.DatosIngrediente;
import com.mgomez.comidita.domain.ingrediente.DatosRegistroIngrediente;
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
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private EtiquetaRepository tagRepository;

    @PostMapping
    public ResponseEntity agregarIngediente(
            @RequestBody @Valid
            DatosAddIngrediente datosIngrediente) {
        Ingrediente ingrediente = ingredienteRepository.save(new Ingrediente(datosIngrediente));
        return ResponseEntity.ok(ingrediente.toString());
    }

    @PostMapping("/etiquetar")
    @Transactional
    public void etiquetarIngrediente(
            @RequestBody @Valid
            DatosEtiquetarIngrediente datosTagIngrediente) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(datosTagIngrediente.idIngrediente());
        ingrediente.etiquetar(datosTagIngrediente.etiquetas());
        System.out.println(ingrediente.getNombre());
        ingredienteRepository.saveAndFlush(ingrediente);


    }

    @GetMapping
    public ResponseEntity<Page<DatosRegistroIngrediente>> listarIngredientes(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(ingredienteRepository.findAll(pageable).map(DatosRegistroIngrediente::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosIngrediente> mostrarIngredientePorID(@PathVariable Long id) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(id);
        DatosIngrediente datosIngrediente = new DatosIngrediente(ingrediente);
        return ResponseEntity.ok(datosIngrediente);
    }


}
