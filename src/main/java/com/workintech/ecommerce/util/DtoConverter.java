package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.*;
import com.workintech.ecommerce.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static ProductResponse productResponseConverter(Product product){
        return new ProductResponse(product.getName(), product.getDescription(), product.getPrice(), product.getStock(),
                new CategoryResponse(product.getCategory().getTitle(),product.getCategory().getGender()), );
    }
    public static List<ProductResponse> productResponseListConverter(List<Product> products){
        List<ProductResponse> responses=new ArrayList<>();
        products.stream().forEach(product -> responses.add(new ProductResponse(product.getName(),
                product.getDescription(), product.getPrice(),product.getStock(),
                new CategoryResponse(product.getCategory().getTitle(),product.getCategory().getGender()),
                )));
        return responses;
    }

    public static CategoryResponse categoryResponseConverter(Category category){
        return new CategoryResponse(category.getTitle(), category.getGender());
    }

    public static List<CategoryResponse> categoryResponseListConverter(List<Category> categories){
        List<CategoryResponse> responses=new ArrayList<>();
        categories.stream().forEach(category -> responses.add(new CategoryResponse(category.getTitle(),category.getGender())));
        return responses;
    }

    public static RoleResponse roleResponseConverter(Role role){
        return new RoleResponse(role.getName(),role.getCode());
    }

    public static List<RoleResponse> roleResponseListConverter(List<Role> roles){
        List<RoleResponse> responses=new ArrayList<>();
        roles.stream().forEach(role -> responses.add(new RoleResponse(role.getName(),role.getCode())));
        return responses;
    }
    public static UserResponse userResponseConverter(User user){
        return new UserResponse(user.getName(),user.getEmail());
    }
}
