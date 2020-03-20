package com.nullxdeadbeef.webshop.repository;

import com.nullxdeadbeef.webshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

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

    @Override
    /*
    add product to product list
     */
    // TODO: figure out generation of id, so we can update later added products
    public void create( Product product ) {
        products.add( product );
    }

    /*
    get specific product
     */
    @Override
    public Product read( Long id ) {
        int i = 0;
        while ( i < products.size() ) {
            if ( products.get( i ).getId().equals( id ) ) {
                return products.get( i );
            }
            i++;
        }
        return null;
    }

    /*
    update information on a product
     */
    @Override
    public boolean update( Product product ) {
        for ( int i = 0; i < products.size(); i++ ) {
            if ( products.get( i ).getId().equals( product.getId() ) ) {
                products.set( i, product );
                return true;
            }
        }

        return false;
    }

    /*
    delete product from product list
     */
    @Override
    public boolean delete( Long id ) {
        for ( int i = 0; i < products.size(); i++ ) {
            if ( products.get( i ).getId().equals( id ) ) {
                products.remove( i );
                return true;
            }
        }

        return false;
    }
}
