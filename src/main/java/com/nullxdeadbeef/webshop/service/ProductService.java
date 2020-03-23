package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        productRepository.findAll().iterator().forEachRemaining( products::add );
        return products;
    }

    public void create( Product product ) {
        productRepository.save( product );
    }

    public Optional<Product> findById(Long id ) {
        return productRepository.findById( id );
    }

    @Override
    public boolean update( Product product ) {
        List<Product> products = getProducts();

        for ( int i = 0; i < products.size(); i++ ) {
            if ( products.get( i ).getId().equals( product.getId() ) ) {
                products.set( i, product );
                return true;
            }
        }

        return false;
    }

    public void deleteById( Long id ) {
        productRepository.deleteById( id );
    }
}
