package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Ingrediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IngredienteRepository extends RepoBase<Ingrediente, Long> {
}
