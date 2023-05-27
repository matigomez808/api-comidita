package com.mgomez.comidita.domain.etiqueta;

import com.mgomez.comidita.domain.etiqueta.records.AddEtiqueta;
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

    public Etiqueta(AddEtiqueta datosAddTag) {
        this.nombre = datosAddTag.nombre();
    }

    public Etiqueta(Long id) {
        this.id = id;
    }
}
