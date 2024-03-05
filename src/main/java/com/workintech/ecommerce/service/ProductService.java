package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

    Product findById(Long id);

    ProductResponse getById(Long id);

    ProductResponse save(Long categoryId, Long storeId,Product product);

    ProductResponse update(Long id,Product product);

    ProductResponse delete(Long id);

    //TODO: Add more find methods for different parameters
}
