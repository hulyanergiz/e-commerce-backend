package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o WHERE o.user.id=:userId")
    List<Order> findOrdersByUserId(Long userId);
}
