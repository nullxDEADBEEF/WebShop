package com.nullxdeadbeef.webshop.controller;

import com.nullxdeadbeef.webshop.model.Company;
import com.nullxdeadbeef.webshop.model.CompanyDescription;
import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.service.CompanyDescriptionService;
import com.nullxdeadbeef.webshop.service.CompanyService;
import com.nullxdeadbeef.webshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final ProductService productService;
    private final CompanyService companyService;
    private final CompanyDescriptionService companyDescriptionService;

    public IndexController( ProductService productService, CompanyService companyService,
                            CompanyDescriptionService companyDescriptionService ) {
        this.productService = productService;
        this.companyService = companyService;
        this.companyDescriptionService = companyDescriptionService;
    }

    @GetMapping( "/" )
    public String getIndexPage( Model model ) {
        model.addAttribute( "products", productService.getProducts() );
        return "index";
    }

    @GetMapping( "/create" )
    public String getCreatePage( Model model ) {
        model.addAttribute( "companies", companyService.getCompanies() );
        return "create";
    }

    // the name of the field inside companyDescription
    @PostMapping( "/create" )
    public String addProduct( @ModelAttribute Product product,
                              @ModelAttribute CompanyDescription companyDescription ) {
        companyDescriptionService.create( companyDescription );
        companyDescription.setProduct( product );
        productService.create( product );
        return "redirect:/";
    }

    @GetMapping( "/update/{id}" )
    public String getUpdatePage( @PathVariable( "id" ) Long id, Model model ) {
        Optional<Product> productOptional = productService.findById( id );
        if ( !productOptional.isPresent() ) {
            throw new RuntimeException( "Product not found" );
        }
        Product product = productOptional.get();
        model.addAttribute( "product", product );
        return "update";
    }

    @PostMapping( "/update" )
    public String sendUpdateChanges( @ModelAttribute Product product ) {
        productService.update( product );
        return "redirect:/";
    }

    @GetMapping( "/delete/{id}" )
    public String delete( @PathVariable( "id" ) Long id ) {
        productService.deleteById( id );
        return "redirect:/";
    }

    @GetMapping( "/details/{id}" )
    public String getProductDetail( @PathVariable( "id" ) Long id, Model model ) {
        Optional<Product> productOptional = productService.findById( id );
        if ( !productOptional.isPresent() ) {
            throw new RuntimeException( "Expected product not found" );
        }
        Long companyId = productOptional.get().getCompany().getId();

        Optional<Company> companyOptional = companyService.findById( companyId );
        if ( !companyOptional.isPresent() ) {
            throw new RuntimeException( "Expected company not found" );
        }
        Company company = companyOptional.get();
        model.addAttribute( "company", company );

        Optional<CompanyDescription> companyDescriptionOptional =
                companyDescriptionService.findById( id );
        if ( !companyDescriptionOptional.isPresent() ) {
            throw new RuntimeException( "Expected company description not found" );
        }

        CompanyDescription companyDescription = companyDescriptionOptional.get();
        model.addAttribute( "company_desc", companyDescription );

        return "product_detail";
    }
}
