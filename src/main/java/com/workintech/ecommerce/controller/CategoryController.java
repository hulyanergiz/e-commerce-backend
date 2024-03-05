package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryResponse save(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id, @Valid @RequestBody Category category){
        return categoryService.update(id,category);
    }

    @DeleteMapping("/{id}")
    public CategoryResponse delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}
