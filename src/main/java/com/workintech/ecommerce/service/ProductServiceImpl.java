package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.ProductRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    private final StoreService storeService;

    @Override
    public List<ProductResponse> findAll() {
        return DtoConverter.productResponseListConverter(productRepository.findAll());
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new EcommerceException("Product is not found with id: "+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse getById(Long id) {
        return DtoConverter.productResponseConverter(findById(id));
    }

    @Override
    public ProductResponse save(Long categoryId,Long storeId,Product product) {
        Category category=categoryService.findById(categoryId);
        category.addProduct(product);
        product.setCategory(category);
        Store store=storeService.findById(storeId);
        store.addProduct(product);
        product.setStore(store);

        return DtoConverter.productResponseConverter(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, Product product) {
        Product productToUpdate=findById(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        return DtoConverter.productResponseConverter(productRepository.save(productToUpdate));

    }

    @Override
    public ProductResponse delete(Long id) {
        Product productToDelete=findById(id);
        if(productToDelete!=null){
            productRepository.delete(productToDelete);
            return DtoConverter.productResponseConverter(productToDelete);
        }
        throw new EcommerceException("Product is not found with id: "+id, HttpStatus.NOT_FOUND);


    }
}
