package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Receta;
import com.mgomez.comidita.domain.records.receta.ListarReceta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RecetaRepository extends RepoBase<Receta, Long> {
}
