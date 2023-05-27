package com.mgomez.comidita.domain.receta;

import com.mgomez.comidita.domain.etiqueta.Etiqueta;
import com.mgomez.comidita.domain.ingrediente.Ingrediente;
import com.mgomez.comidita.domain.receta.records.AddReceta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "recetas")
@Entity(name = "receta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "instrucciones")
    private String instrucciones;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ingredientes")
    @ManyToMany
    @JoinTable(
            name = "map_ingredientes_receta",
            joinColumns = @JoinColumn ( name = "receta_id"),
            inverseJoinColumns = @JoinColumn (name = "ingrediente_id")
    ) //  map_recetas_ingredientes
    private List<Ingrediente> listaIngredientes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "map_receta_etiqueta",
            joinColumns = @JoinColumn (name = "receta_id"),
            inverseJoinColumns = @JoinColumn (name = "etiqueta_id")
    )
    private List<Etiqueta> listaEtiquetas = new ArrayList<>();
    @Column(name = "activo")
    private boolean activo;

    public Receta(AddReceta datosAddReceta) {
        this.nombre = datosAddReceta.nombre();
        this.descripcion =datosAddReceta.descripcion();
        this.instrucciones = datosAddReceta.instrucciones();
        this.listaIngredientes = datosAddReceta.listaIngredientes();
        if (datosAddReceta.listaEtiquetas() != null)
            this.listaEtiquetas = datosAddReceta.listaEtiquetas();
    }

    public void etiquetar(List<Etiqueta> etiquetas) {
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!this.listaEtiquetas.contains(etiquetaNueva)) {
                this.listaEtiquetas.add(etiquetaNueva);
                System.out.println(this.nombre + " etiquetado como: " + etiquetaNueva.getNombre());
            }
        }

    }

    public void desactivar() {
        this.activo = false;
    }
}
