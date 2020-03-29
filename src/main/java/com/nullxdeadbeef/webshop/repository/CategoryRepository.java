package com.nullxdeadbeef.webshop.repository;

import com.nullxdeadbeef.webshop.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Optional<Category> findByName( String name );
}
