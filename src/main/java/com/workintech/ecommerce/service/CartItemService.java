package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CartItemResponse;
import com.workintech.ecommerce.entity.CartItem;

import java.util.List;

public interface CartItemService {

    List<CartItemResponse> findAllForUser(Long userId);

    CartItem findById(Long id);

    CartItemResponse getById(Long id);

    CartItemResponse save(Long userId,CartItem cartItem);

    CartItemResponse delete(Long userId,Long id);
}
