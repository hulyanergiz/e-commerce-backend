package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.OrderResponse;
import com.workintech.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAllForUser(Long userId);

    Order findById(Long id);

    OrderResponse getById(Long id);

    OrderResponse save(Long userId,Order order);

    OrderResponse delete(Long userId,Long id);

}
