package com.nullxdeadbeef.webshop.model;

import javax.persistence.*;

/*
The company's description of the product
 */
@Entity
@Table( name = "company_descriptions" )
public class CompanyDescription {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String cDescription;

    @OneToOne
    private Product product;

    public CompanyDescription() {
    }

    public CompanyDescription( Long id, String cDescription ) {
        this.id = id;
        this.cDescription = cDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public String getCDescription() {
        return cDescription;
    }

    public void setCDescription( String description ) {
        this.cDescription = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct( Product product ) {
        this.product = product;
    }
}
