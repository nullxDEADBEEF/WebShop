package com.nullxdeadbeef.webshop.controller;

import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    // As far as I understand @AutoWired removes the need for
    // getters and setters????
    @Autowired
    ProductService productService;

    @GetMapping( "/" )
    public String getIndexPage( Model model ) {
        model.addAttribute( "products", productService.readProducts() );
        return "index";
    }

    @GetMapping( "/create" )
    public String getCreatePage() {
        return "create";
    }

    @PostMapping( "/create" )
    public String addProduct(@ModelAttribute Product product ) {
        productService.create( product );
        return "redirect:/";
    }
}
