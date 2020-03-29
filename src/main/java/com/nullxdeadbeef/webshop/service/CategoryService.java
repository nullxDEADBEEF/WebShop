package com.nullxdeadbeef.webshop.service;

import com.nullxdeadbeef.webshop.model.Category;
import com.nullxdeadbeef.webshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService( CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        categoryRepository.findAll().iterator().forEachRemaining( categories::add );
        return categories;
    }

    public void create( Category category ) {
        categoryRepository.save( category );
    }

    public Optional<Category> findById( Long id ) {
        return categoryRepository.findById( id );
    }

    public void deleteById( Long id ) {
        categoryRepository.deleteById( id );
    }
}
