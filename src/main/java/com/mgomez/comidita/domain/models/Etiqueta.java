package com.mgomez.comidita.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgomez.comidita.domain.records.etiqueta.AddEtiqueta;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "etiquetas")
@Entity(name = "etiqueta")
@Getter
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

    private boolean activo;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaEtiquetasReceta")
    private List<Receta> recetas;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaEtiquetasIngrediente")
    private List<Ingrediente> ingredientes;

    public Etiqueta(AddEtiqueta datosAddTag) {
        this.nombre = datosAddTag.nombre();
        this.activo = true;
    }

    public Etiqueta(Long id) {
        this.id = id;
    }
}
