package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.AddressResponse;
import com.workintech.ecommerce.entity.Address;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAllForUser(Long userId);

    Address findById(Long id);

    AddressResponse getById(Long id);

    AddressResponse save(Long userId,Address address);

    AddressResponse delete(Long userId,Long id);


}
