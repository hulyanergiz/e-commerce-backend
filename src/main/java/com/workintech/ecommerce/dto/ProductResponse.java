package com.workintech.ecommerce.dto;

public record ProductResponse(String name, String description, Double price, Long stock, CategoryResponse category, StoreResponse store) {
}