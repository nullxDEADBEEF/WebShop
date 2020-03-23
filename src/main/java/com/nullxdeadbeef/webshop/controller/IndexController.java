package com.nullxdeadbeef.webshop.controller;

import com.nullxdeadbeef.webshop.model.Product;
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

    public IndexController( ProductService productService, CompanyService companyService ) {
        this.productService = productService;
        this.companyService = companyService;
    }

    @GetMapping( "/" )
    public String getIndexPage( Model model ) {
        model.addAttribute( "products", productService.getProducts() );
        model.addAttribute( "companies", companyService.getCompanies() );
        return "index";
    }

    @GetMapping( "/create" )
    public String getCreatePage() {
        return "create";
    }

    @PostMapping( "/create" )
    public String addProduct( @ModelAttribute Product product ) {
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

    @GetMapping( "/detail/{id}" )
    public String productDetail( @PathVariable( "id" ) Long id, Model model ) {
        return "product_detail";
    }
}
