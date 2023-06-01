package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.models.IngredienteReceta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRecetaRepository extends JpaRepository<IngredienteReceta, Long> {

}
