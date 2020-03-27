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
    private String description;

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "companyDescription")
    private Product product;

    public CompanyDescription() {
    }

    public CompanyDescription( Long id, String description ) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct( Product product ) {
        this.product = product;
    }
}
