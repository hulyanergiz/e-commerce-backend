package com.workintech.ecommerce.dto;

public record RegisterUserResponse(String name, String email, String password,Long roleId) {
}
