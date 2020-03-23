package com.nullxdeadbeef.webshop.repository;

import com.nullxdeadbeef.webshop.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    public Optional<Company> findByName(String desc );
}
