package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends RepoBase<Etiqueta, Long> {

}
