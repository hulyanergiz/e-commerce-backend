package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.CategoryRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final RestTemplate restTemplate;
    private final String ecommerceApiUrl="https://workintech-fe-ecommerce.onrender.com/categories";


    @Override
    public List<CategoryResponse> findAll() {
        URI uri = UriComponentsBuilder.fromHttpUrl(ecommerceApiUrl)
                .build()
                .toUri();
        ResponseEntity<CategoryResponse[]> responseEntity=restTemplate.getForEntity(uri,CategoryResponse[].class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
        }else{
            throw new EcommerceException("Categories could not found",HttpStatus.NOT_FOUND);
        }
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
