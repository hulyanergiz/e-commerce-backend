package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    @Query("SELECT c FROM Card c WHERE c.user.id=:userId")
    List<Card> findCardsByUserId(Long userId);
}
