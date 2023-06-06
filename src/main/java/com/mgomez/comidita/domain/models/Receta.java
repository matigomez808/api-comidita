package com.mgomez.comidita.domain.models;

import com.mgomez.comidita.domain.records.receta.AddReceta;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Table(name = "recetas")
@Entity(name = "receta")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique=true)
    private String nombre;

    @Column
    private String instrucciones;

    @Column
    private String descripcion;

    @Column
    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredienteReceta> listaIngredientes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "receta_etiqueta",
            joinColumns = @JoinColumn(name = "receta_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> listaEtiquetasReceta;

    @Column
    private boolean activo = true;

    public Receta(AddReceta data) {
        this.nombre = data.nombre();
        this.descripcion = data.descripcion();
        this.instrucciones = data.instrucciones();
        if (data.listaEtiquetas() != null)
            this.listaEtiquetasReceta = data.listaEtiquetas();
    }

    public void etiquetar(List<Etiqueta> etiquetas) {
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!this.listaEtiquetasReceta.contains(etiquetaNueva)) {
                this.listaEtiquetasReceta.add(etiquetaNueva);
                System.out.println(this.nombre + " etiquetado como: " + etiquetaNueva.getNombre());
            }
        }

    }

    public void desactivar() {
        this.activo = false;
    }
}
