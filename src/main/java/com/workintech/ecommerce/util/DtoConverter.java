package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.*;
import com.workintech.ecommerce.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static ProductResponse productResponseConverter(Product product){
        return new ProductResponse(product.getName(), product.getDescription(), product.getPrice(), product.getStock(),
                categoryResponseConverter(product.getCategory()),
                storeResponseConverter(product.getStore()));
    }
    public static List<ProductResponse> productResponseListConverter(List<Product> products){
        List<ProductResponse> responses=new ArrayList<>();
        products.forEach(product -> responses.add(new ProductResponse(product.getName(),
                product.getDescription(), product.getPrice(),product.getStock(),
                categoryResponseConverter(product.getCategory()),
                storeResponseConverter(product.getStore()))));
        return responses;
    }

    public static CategoryResponse categoryResponseConverter(Category category){
        return new CategoryResponse(category.getTitle(), category.getGender());
    }

    public static List<CategoryResponse> categoryResponseListConverter(List<Category> categories){
        List<CategoryResponse> responses=new ArrayList<>();
        categories.forEach(category -> responses.add(new CategoryResponse(category.getTitle(),category.getGender())));
        return responses;
    }

    public static RoleResponse roleResponseConverter(Role role){
        return new RoleResponse(role.getName(),role.getCode());
    }

    public static List<RoleResponse> roleResponseListConverter(List<Role> roles){
        List<RoleResponse> responses=new ArrayList<>();
        roles.forEach(role -> responses.add(new RoleResponse(role.getName(),role.getCode())));
        return responses;
    }
    public static UserResponse userResponseConverter(User user){
        return new UserResponse(user.getName(),user.getEmail());
    }

    public static StoreResponse storeResponseConverter(Store store){
        return new StoreResponse(store.getName(), store.getPhone(), store.getTaxNumber());
    }

    public static List<StoreResponse> storeResponseListConverter(List<Store> stores){
        List<StoreResponse> responses=new ArrayList<>();
        stores.forEach(store -> responses.add(storeResponseConverter(store)));
        return responses;
    }

    public static CartItemResponse cartItemResponseConverter(CartItem cartItem){
        return new CartItemResponse(new ProductResponse(cartItem.getProduct().getName(),cartItem.getProduct().getDescription(),
                cartItem.getProduct().getPrice(),cartItem.getProduct().getStock(),
                categoryResponseConverter(cartItem.getProduct().getCategory()),
                storeResponseConverter(cartItem.getProduct().getStore())),cartItem.getCount());
    }

    public static List<CartItemResponse> cartItemResponseListConverter(List<CartItem> cartItems){
        List<CartItemResponse> responses=new ArrayList<>();
        cartItems.forEach(cartItem->responses.add(new CartItemResponse(new ProductResponse(cartItem.getProduct().getName(),cartItem.getProduct().getDescription(),
                cartItem.getProduct().getPrice(),cartItem.getProduct().getStock(),
                categoryResponseConverter(cartItem.getProduct().getCategory()),
                storeResponseConverter(cartItem.getProduct().getStore())),cartItem.getCount())));
        return responses;
    }

    public static AddressResponse addressResponseConverter(Address address){
        return new AddressResponse(address.getName(), address.getSurname(), address.getPhone(), address.getCity(),
                address.getDistrict(), address.getNeighborhood(), address.getAddressDetails());
    }

    public static List<AddressResponse> addressResponseListConverter(List<Address> addresses){
        List<AddressResponse> addressResponses=new ArrayList<>();
        addresses.forEach(address -> addressResponses.add(new AddressResponse(address.getName(), address.getSurname(), address.getPhone(), address.getCity(),
                address.getDistrict(), address.getNeighborhood(), address.getAddressDetails())));
        return addressResponses;
    }

    public static CardResponse cardResponseConverter(Card card){
        return new CardResponse(card.getCardTitle());
    }

    public static List<CardResponse> cardResponseListConverter(List<Card> cards){
        List<CardResponse> cardResponses=new ArrayList<>();
        cards.forEach(card -> cardResponses.add(new CardResponse(card.getCardTitle())));
        return cardResponses;
    }

    public static OrderResponse orderResponseConverter(Order order){
        return new OrderResponse(order.getId(), order.getOrderDate(), order.getPrice(),cartItemResponseListConverter(order.getCartItems()),
                addressResponseConverter(order.getAddress()),cardResponseConverter(order.getCard()));

    }

    public static List<OrderResponse> orderResponseListConverter(List<Order> orders){
        List<OrderResponse> orderResponses=new ArrayList<>();
        orders.forEach(order -> orderResponses.add(new OrderResponse(order.getId(), order.getOrderDate(), order.getPrice(),
                cartItemResponseListConverter(order.getCartItems()),addressResponseConverter(order.getAddress()),cardResponseConverter(order.getCard()))));
        return orderResponses;
    }

}
