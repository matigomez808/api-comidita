package com.mgomez.comidita.domain.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepoPages<T, ID> extends PagingAndSortingRepository<T, ID> {
}
