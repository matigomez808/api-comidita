package com.mgomez.comidita.domain.models;

import com.mgomez.comidita.domain.records.ingrediente.AddIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.Gondola;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "ingredientes")
@Entity(name = "ingrediente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String nombre;

    @Column
    private String descripcion;
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ingrediente_etiqueta",
            joinColumns = @JoinColumn(name = "ingrediente_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> listaEtiquetasIngrediente;

    @Enumerated(EnumType.STRING)
    @Column
    private Gondola gondola;

    @Column
    private boolean activo = true;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredienteReceta> listaIngredientesReceta;

    public Ingrediente(AddIngrediente datosAddIngrediente) {
        this.descripcion = datosAddIngrediente.descripcion();
        this.nombre = datosAddIngrediente.nombre();
        this.gondola = datosAddIngrediente.gondola();
        if (datosAddIngrediente.listaEtiquetas() != null){
            this.listaEtiquetasIngrediente = datosAddIngrediente.listaEtiquetas();
        }
    }

    public Ingrediente(Long id) {
        this.id = id;
    }

    public void etiquetar(List<Etiqueta> etiquetas) {
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!this.listaEtiquetasIngrediente.contains(etiquetaNueva)) this.listaEtiquetasIngrediente.add(etiquetaNueva);
        }
    }

    public void desactivar() {
        this.activo = false;
    }
}
