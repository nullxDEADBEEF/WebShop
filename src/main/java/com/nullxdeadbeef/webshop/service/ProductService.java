package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> readProducts() {
        return productRepository.getProducts();
    }

    public void create( Product product ) {
        productRepository.create( product );
    }
}
