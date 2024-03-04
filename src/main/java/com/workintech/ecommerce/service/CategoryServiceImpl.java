package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.CategoryRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findAll() {
        return DtoConverter.categoryResponseListConverter(categoryRepository.findAll());
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> optionalCategory=categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        throw new EcommerceException("Category is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CategoryResponse getById(Long id) {
        return DtoConverter.categoryResponseConverter(findById(id));
    }

    @Override
    public CategoryResponse save(Category category) {
        return DtoConverter.categoryResponseConverter(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse update(Long id, Category category) {
        Category categoryToUpdate=findById(id);
        categoryToUpdate.setTitle(category.getTitle());
        categoryToUpdate.setGender(category.getGender());
        return DtoConverter.categoryResponseConverter(categoryRepository.save(categoryToUpdate));
    }

    @Override
    public CategoryResponse delete(Long id) {
        Category categoryToDelete=findById(id);
        categoryRepository.delete(categoryToDelete);
        return DtoConverter.categoryResponseConverter(categoryToDelete);
    }
}
