package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Ingrediente;
import org.springframework.data.repository.CrudRepository;

public interface RepoBase<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAllByActivoTrue();
}
