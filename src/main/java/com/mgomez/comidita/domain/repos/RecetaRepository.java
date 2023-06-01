package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Receta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    Page<Receta> findByActivoTrue(Pageable pageable);
}
