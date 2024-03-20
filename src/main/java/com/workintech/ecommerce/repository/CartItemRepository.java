package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("SELECT c FROM CartItem c WHERE c.user.id=:userId")
    List<CartItem> findCartItemsByUserId(Long userId);

    @Query("SELECT c FROM CartItem c WHERE c.user.id = :userId AND c.id=:id")
    Optional<CartItem> findCardItemForUser(Long userId,Long id);
}

