package com.jetlore.newsformatter.type.repository;

import com.jetlore.newsformatter.type.model.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {
    Type findByName(final String name);
}
