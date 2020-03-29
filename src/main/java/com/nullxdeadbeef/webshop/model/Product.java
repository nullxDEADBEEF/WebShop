package com.nullxdeadbeef.webshop.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

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

    @ManyToMany
    @JoinTable( name = "product_category",
                joinColumns = @JoinColumn( name = "product_id" ),
                inverseJoinColumns = @JoinColumn( name = "category_id" ) )
    List<Category> categories;

    public Product() {
    }

    public Product( Long id, String name, double price, String description,
                    Company company, CompanyDescription companyDescription,
                    List<Category> categories ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.company = company;
        this.companyDescription = companyDescription;
        companyDescription.setProduct( this );
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories( List<Category> categories ) {
        this.categories = categories;
    }
}
