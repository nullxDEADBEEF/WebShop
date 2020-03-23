package com.nullxdeadbeef.webshop.repository;

import com.nullxdeadbeef.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
