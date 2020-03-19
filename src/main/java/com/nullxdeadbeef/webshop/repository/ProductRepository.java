package com.nullxdeadbeef.webshop.repository;

import com.nullxdeadbeef.webshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add( new Product( 1L, "Coffee", 45.0, "Delicious Coffee" ) );
        products.add( new Product( 2L, "Tea", 30.0, "Exquisite tea from China" ) );
        products.add( new Product( 3L, "Coca Cola", 5.0, "VERY delicious softdrink" ) );
        products.add( new Product( 4L, "Pepsi Max", 3.0, "The less good Coca Cola" ) );
        products.add( new Product( 5L, "Sour Candy", 25.0, "A bag of sour candy, perfect for people with a sweet tooth") );
    }

    public List<Product> getProducts() {
        return products;
    }

    public void create( Product product ) {
        products.add( product );
    }
}
