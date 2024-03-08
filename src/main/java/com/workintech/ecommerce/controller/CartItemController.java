package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CartItemResponse;
import com.workintech.ecommerce.entity.CartItem;
import com.workintech.ecommerce.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/user/{userId}")
    public List<CartItemResponse> findAllForUser(@PathVariable Long userId){
        return cartItemService.findAllForUser(userId);
    }

    @GetMapping("/{id}")
    public CartItemResponse getById(@PathVariable Long id){
        return cartItemService.getById(id);
    }

    @PostMapping("/user/{userId}")
    public CartItemResponse save(@PathVariable Long userId, @RequestBody CartItem cartItem){
       return cartItemService.save(userId,cartItem);
    }
    @DeleteMapping("/user/{userId}/{id}")
    public CartItemResponse delete(@PathVariable Long userId,@PathVariable Long id){
        return cartItemService.delete(userId,id);

    }
}
