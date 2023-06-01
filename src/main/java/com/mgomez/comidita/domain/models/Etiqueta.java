package com.mgomez.comidita.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgomez.comidita.domain.records.etiqueta.AddEtiqueta;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "etiquetas")
@Entity(name = "etiqueta")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique=true)
    private String nombre;
    @JsonIgnore
    @ManyToMany(mappedBy = "listaEtiquetasReceta")
    private List<Receta> recetas;
    @JsonIgnore
    @ManyToMany(mappedBy = "listaEtiquetasIngrediente")
    private List<Ingrediente> ingredientes;

    public Etiqueta(AddEtiqueta datosAddTag) {
        this.nombre = datosAddTag.nombre();
    }

    public Etiqueta(Long id) {
        this.id = id;
    }
}
