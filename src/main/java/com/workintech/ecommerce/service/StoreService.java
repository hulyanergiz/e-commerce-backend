package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.StoreResponse;
import com.workintech.ecommerce.entity.Store;

import java.util.List;

public interface StoreService {

    List<StoreResponse> findAll();

    Store findById(Long id);

    StoreResponse save(Store store);

    StoreResponse update(Long id,Store store);

    StoreResponse delete(Long id);

}
