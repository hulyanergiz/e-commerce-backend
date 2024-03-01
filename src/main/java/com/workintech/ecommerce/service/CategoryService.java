package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();

    Category findById(Long id);

    CategoryResponse getById(Long id);

    CategoryResponse save(Category category);

    CategoryResponse update(Long id, Category category);

    CategoryResponse delete(Long id);

    //TODO:Add more find methods for different parameters
}
