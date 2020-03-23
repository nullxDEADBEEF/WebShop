package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getProducts();
    public boolean update( Product product );
}
