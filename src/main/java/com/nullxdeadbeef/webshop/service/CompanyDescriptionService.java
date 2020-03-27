package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.CompanyDescription;
import com.nullxdeadbeef.webshop.repository.CompanyDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyDescriptionService {

    private final CompanyDescriptionRepository companyDescriptionRepository;

    public CompanyDescriptionService( CompanyDescriptionRepository companyDescriptionRepository ) {
        this.companyDescriptionRepository = companyDescriptionRepository;
    }

    public void create(CompanyDescription companyDescription ) {
        companyDescriptionRepository.save( companyDescription );
    }

    public Optional<CompanyDescription> findById( Long id ) {
        return companyDescriptionRepository.findById( id );
    }

    public void deleteById( Long id ) {
        companyDescriptionRepository.deleteById( id );
    }
}
