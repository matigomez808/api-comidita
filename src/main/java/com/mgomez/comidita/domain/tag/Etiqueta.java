package com.mgomez.comidita.domain.tag;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    public Etiqueta(DatosAddEtiqueta datosAddTag) {
        this.nombre = datosAddTag.nombre();
    }

    public Etiqueta(Long id) {
        this.id = id;
    }
}
