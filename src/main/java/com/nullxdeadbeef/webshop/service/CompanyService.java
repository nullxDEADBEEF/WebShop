package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.Company;
import com.nullxdeadbeef.webshop.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService( CompanyRepository companyRepository ) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();

        companyRepository.findAll().iterator().forEachRemaining( companies::add );
        return companies;
    }

    public void create( Company company ) {
        companyRepository.save( company );
    }

    public Optional<Company> findById( Long id ) {
        return companyRepository.findById( id );
    }

    public void deleteById( Long id ) {
        companyRepository.deleteById( id );
    }
}
