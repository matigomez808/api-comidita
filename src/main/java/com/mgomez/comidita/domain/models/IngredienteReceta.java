package com.mgomez.comidita.domain.models;

import com.mgomez.comidita.domain.records.ingrediente.Unidad;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "ingredientes_receta")
@Entity(name = "ingrediente_receta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class IngredienteReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @Column
    private Integer cantidad;

    @Enumerated(EnumType.STRING)
    @Column
    Unidad unidad;

    public IngredienteReceta(Long ingrediente_id, Unidad unidad, Integer cantidad){
        this.id = ingrediente_id;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }


}