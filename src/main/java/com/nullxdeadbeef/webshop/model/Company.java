package com.nullxdeadbeef.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "company" )
    private List<Product> products;

    public Company() {
    }

    public Company( Long id, String name ) {
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
}
