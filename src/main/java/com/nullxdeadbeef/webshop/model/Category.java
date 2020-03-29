package com.nullxdeadbeef.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "categories" )
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    @ManyToMany( mappedBy = "categories" )
    List<Product> products;

    public Category() {
    }

    public Category( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts( List<Product> products ) {
        this.products = products;
    }
}
