package com.mgomez.comidita.domain.ingrediente;

import com.mgomez.comidita.domain.etiqueta.Etiqueta;
import com.mgomez.comidita.domain.ingrediente.records.AddIngrediente;
import com.mgomez.comidita.domain.ingrediente.records.TipoComida;
import com.mgomez.comidita.domain.ingrediente.records.Unidad;
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

    @Enumerated(EnumType.STRING)
    @Column (name = "tipoComida")
    private TipoComida tipoComida;

    @Enumerated(EnumType.STRING)
    @Column(name = "cantidad")
    private int cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidad")
    private Unidad unidad;

    @Column(name = "activo")
    private boolean activo;

    @Enumerated(EnumType.STRING)
    @Column(name = "gondola")
    private Gondola gondola;




    public Ingrediente(AddIngrediente datosIngrediente) {
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

    public void desactivar() {
        this.activo = false;
    }
}
