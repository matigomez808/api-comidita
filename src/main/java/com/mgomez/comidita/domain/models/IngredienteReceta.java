package com.mgomez.comidita.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mgomez.comidita.domain.records.ingrediente.Unidad;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "ingredientes_receta")
@Entity(name = "ingrediente_receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class IngredienteReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @Column
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column
    Unidad unidad;

    private String nombre;
//    public IngredienteReceta(Ingrediente ingrediente, Receta receta , Unidad unidad, Integer cantidad){
//        this.ingrediente = ingrediente;
//        this.receta = receta;
//        this.cantidad = cantidad;
//        this.unidad = unidad;

    public IngredienteReceta(Long id, Unidad unidad, Integer cantidad){
        this.id = id;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }


}