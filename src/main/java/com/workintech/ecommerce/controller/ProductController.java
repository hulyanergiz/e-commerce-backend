package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/categoryId/{categoryId}/storeId/{storeId}")
    public ProductResponse save(@PathVariable Long categoryId,@PathVariable Long storeId,@Valid @RequestBody Product product){
        return productService.save(categoryId,storeId,product);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id,@Valid @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
