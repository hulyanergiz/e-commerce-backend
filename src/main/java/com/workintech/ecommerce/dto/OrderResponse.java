package com.workintech.ecommerce.dto;

public record OrderResponse(Long id, String orderDate, double price, AddressResponse address) {
}
