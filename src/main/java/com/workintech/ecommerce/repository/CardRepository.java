package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
