package com.nullxdeadbeef.webshop.bootstrap;

import com.nullxdeadbeef.webshop.model.Company;
import com.nullxdeadbeef.webshop.model.CompanyDescription;
import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.repository.CompanyDescriptionRepository;
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
    private final CompanyDescriptionRepository companyDescriptionRepository;

    public ProductBootstrap( ProductRepository productrepository, CompanyRepository companyRepository,
                             CompanyDescriptionRepository companyDescriptionRepository ) {
        this.productrepository = productrepository;
        this.companyRepository = companyRepository;
        this.companyDescriptionRepository = companyDescriptionRepository;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent contextRefreshedEvent ) {
        companyDescriptionRepository.saveAll( getCompanyDescriptions() );
        companyRepository.saveAll( getCompanies() );
        productrepository.saveAll( getProducts() );
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        // get company names
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

        // get company descriptions
        Optional<CompanyDescription> coffeeDescOptional =
                companyDescriptionRepository.findById( 1L );
        if ( !coffeeDescOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription coffeeDesc = coffeeDescOptional.get();

        Optional<CompanyDescription> teaDescOptional =
                companyDescriptionRepository.findById( 2L );
        if ( !teaDescOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription teaDesc = teaDescOptional.get();

        Optional<CompanyDescription> cocaColaDescOptional =
                companyDescriptionRepository.findById( 3L );
        if ( !cocaColaDescOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription cocaColaDesc = cocaColaDescOptional.get();

        Optional<CompanyDescription> pepsiDescOptional =
                companyDescriptionRepository.findById( 4L );
        if ( !pepsiDescOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription pepsiMaxDesc = pepsiDescOptional.get();

        Optional<CompanyDescription> sourCandyDescOptional =
                companyDescriptionRepository.findById( 5L );
        if ( !sourCandyDescOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription sourCandyDesc = sourCandyDescOptional.get();

        products.add( new Product( 1L, "Coffee", 45.0, "Delicious Coffee",
                nescafe, coffeeDesc ) );
        products.add( new Product( 2L, "Tea", 30.0, "Exquisite tea from " +
                "China", lipton, teaDesc ) );
        products.add( new Product( 3L, "Coca Cola", 5.0, "VERY delicious " +
                "softdrink", cocaCola, cocaColaDesc ) );
        products.add( new Product( 4L, "Pepsi Max", 3.0, "The inferior Coca " +
                "Cola", pepsi, pepsiMaxDesc ) );
        products.add( new Product( 5L, "Sour Candy", 25.0, "A bag of sour " +
                "candy, perfect for people with a sweet tooth", haribo,
                sourCandyDesc ) );

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

    /*
    get the companies description of products
     */
    private List<CompanyDescription> getCompanyDescriptions() {
        List<CompanyDescription> descriptions = new ArrayList<>();

        descriptions.add( new CompanyDescription( 1L, "Denmark's best coffee," +
                " with beans from another world" ) );
        descriptions.add( new CompanyDescription( 2L, "Tea from China, " +
                "gathered from ancient traditions of tea leafs" ) );
        descriptions.add( new CompanyDescription( 3L, "'For the det min " +
                "yndlings sodavand....'" ) );
        descriptions.add( new CompanyDescription( 4L, "We cant compete with " +
                "Coca Cola... what do?" ) );
        descriptions.add( new CompanyDescription( 5L, "The best candy a man " +
                "can get" ) );

        return descriptions;
    }
}
