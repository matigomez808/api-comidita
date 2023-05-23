package com.mgomez.comidita.domain.ingrediente;

import com.mgomez.comidita.domain.tag.Etiqueta;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "etiquetas")
    @ManyToMany
    @JoinTable(
            name = "map_ingrediente_etiqueta",
            joinColumns = @JoinColumn(name = "ingrediente_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> listaEtiquetas = new ArrayList<>();


    public Ingrediente(DatosAddIngrediente datosIngrediente) {
        this.descripcion = datosIngrediente.descripcion();
        this.nombre = datosIngrediente.nombre();
    }
    public Ingrediente(Long id) {
        this.id = id;
    }

    public void etiquetar(List<Etiqueta> etiquetas) {
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!this.listaEtiquetas.contains(etiquetaNueva)) this.listaEtiquetas.add(etiquetaNueva);
        }
    }
}
