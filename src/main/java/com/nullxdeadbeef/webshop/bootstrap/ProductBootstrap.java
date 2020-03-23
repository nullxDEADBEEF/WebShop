package com.nullxdeadbeef.webshop.bootstrap;

import com.nullxdeadbeef.webshop.model.Company;
import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.repository.CompanyRepository;
import com.nullxdeadbeef.webshop.repository.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productrepository;
    private final CompanyRepository companyRepository;

    public ProductBootstrap( ProductRepository productrepository, CompanyRepository companyRepository ) {
        this.productrepository = productrepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent contextRefreshedEvent ) {
        companyRepository.saveAll( getCompanies() );
        productrepository.saveAll( getProducts() );
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Optional<Company> nescafeOptional = companyRepository.findByName( "Nescafe" );

        if ( !nescafeOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }

        Company nescafe = nescafeOptional.get();

        Optional<Company> liptonOptional = companyRepository.findByName( "Lipton" );

        if ( !liptonOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }

        Company lipton = liptonOptional.get();

        Optional<Company> cocaColaOptional = companyRepository.findByName( "Coca Cola" );

        if ( !cocaColaOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }

        Company cocaCola = cocaColaOptional.get();

        Optional<Company> pepsiOptional = companyRepository.findByName( "Pepsi" );

        if ( !pepsiOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }

        Company pepsi = pepsiOptional.get();

        Optional<Company> hariboOptional = companyRepository.findByName( "Haribo" );

        if ( !hariboOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }

        Company haribo = hariboOptional.get();

        products.add( new Product( 1L, "Coffee", 45.0, "Delicious Coffee", nescafe ) );
        products.add( new Product( 2L, "Tea", 30.0, "Exquisite tea from China", lipton ) );
        products.add( new Product( 3L, "Coca Cola", 5.0, "VERY delicious softdrink", cocaCola ) );
        products.add( new Product( 4L, "Pepsi Max", 3.0, "The less good Coca Cola", pepsi ) );
        products.add( new Product( 5L, "Sour Candy", 25.0, "A bag of sour candy, perfect for people with a sweet tooth", haribo ) );

        return products;
    }

    private List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();

        companies.add( new Company( 1L, "Nescafe" ) );
        companies.add( new Company( 2L, "Lipton" ) );
        companies.add( new Company( 3L, "Coca Cola" ) );
        companies.add( new Company( 4L, "Pepsi" ) );
        companies.add( new Company( 5L, "Haribo" ) );

        return companies;
    }
}
