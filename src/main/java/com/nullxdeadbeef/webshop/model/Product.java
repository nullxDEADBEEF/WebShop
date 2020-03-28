package com.nullxdeadbeef.webshop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table( name = "products" )
public class Product {

    @Id
    // let my MySQL give the next key
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    @Min( 0 )
    private double price;

    @Size( max = 250 )
    private String description;

    @ManyToOne( fetch = FetchType.EAGER )
    private Company company;

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "product" )
    private CompanyDescription companyDescription;

    public Product() {
    }

    public Product( Long id, String name, double price, String description,
                    Company company, CompanyDescription companyDescription ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.company = company;
        this.companyDescription = companyDescription;
        companyDescription.setProduct( this );
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

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany( Company company ) {
        this.company = company;
    }

    public CompanyDescription getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription( CompanyDescription companyDescription ) {
        this.companyDescription = companyDescription;
    }
}
