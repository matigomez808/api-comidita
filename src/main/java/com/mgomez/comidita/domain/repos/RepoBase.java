package com.mgomez.comidita.domain.repos;

import com.mgomez.comidita.domain.models.Ingrediente;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface RepoBase<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAllByActivoTrue();
}
