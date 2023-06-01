package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Ingrediente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    Page<Ingrediente> findByActivoTrue(Pageable pageable);
}
