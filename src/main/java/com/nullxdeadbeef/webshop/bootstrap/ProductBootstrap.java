package com.nullxdeadbeef.webshop.bootstrap;

import com.nullxdeadbeef.webshop.model.Product;
import com.nullxdeadbeef.webshop.repository.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productrepository;

    public ProductBootstrap( ProductRepository productrepository ) {
        this.productrepository = productrepository;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent contextRefreshedEvent ) {
        productrepository.saveAll( getProducts() );
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add( new Product( 1L, "Coffee", 45.0, "Delicious Coffee" ) );
        products.add( new Product( 2L, "Tea", 30.0, "Exquisite tea from China" ) );
        products.add( new Product( 3L, "Coca Cola", 5.0, "VERY delicious softdrink" ) );
        products.add( new Product( 4L, "Pepsi Max", 3.0, "The less good Coca Cola" ) );
        products.add( new Product( 5L, "Sour Candy", 25.0, "A bag of sour candy, perfect for people with a sweet tooth") );

        return products;
    }
}
