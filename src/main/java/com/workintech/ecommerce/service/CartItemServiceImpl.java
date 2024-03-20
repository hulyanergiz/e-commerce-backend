package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CartItemResponse;
import com.workintech.ecommerce.entity.CartItem;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.CartItemRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService{
    private final CartItemRepository cartItemRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public List<CartItemResponse> findAllForUser(Long userId) {
        return DtoConverter.cartItemResponseListConverter(cartItemRepository.findCartItemsByUserId(userId));
    }

    @Override
    public CartItem findById(Long id) {
        Optional<CartItem> optionalCartItem=cartItemRepository.findById(id);
        if(optionalCartItem.isPresent()){
            CartItem cartItem = optionalCartItem.get();
            Long userId = cartItem.getUser().getId();
            Optional<CartItem> userCartItem = cartItemRepository.findCardItemForUser(userId, id);
            if (userCartItem.isPresent()) {
                return userCartItem.get();
            }
        }
        throw new EcommerceException("Cart item is not found with id: "+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public CartItemResponse getById(Long id) {
        return DtoConverter.cartItemResponseConverter(findById(id));
    }

    @Override
    public CartItemResponse save(Long userId, CartItem cartItem) {
        User user=userService.findById(userId);
        cartItem.setUser(user);
        Long productId=cartItem.getProduct().getId();
        Product product=productService.findById(productId);
        cartItem.setProduct(product);
        user.getCartItems().add(cartItem);
        return DtoConverter.cartItemResponseConverter(cartItemRepository.save(cartItem));
    }

    @Override
    public CartItemResponse delete(Long userId, Long id) {
        CartItem cardItemToDelete=findById(id);
        if(cardItemToDelete.getUser().getId().equals(userId)){
            cartItemRepository.delete(cardItemToDelete);
            return DtoConverter.cartItemResponseConverter(cardItemToDelete);
        }
        throw new EcommerceException("Cart item to delete is not found with id: "+id,HttpStatus.NOT_FOUND);
    }

}
