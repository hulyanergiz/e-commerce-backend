package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CardResponse;
import com.workintech.ecommerce.entity.Card;

import java.util.List;

public interface CardService {

    List<CardResponse> findAllForUser(Long userId);

    Card findById(Long id);

    CardResponse getById(Long id);

    CardResponse save(Long userId,Card card);

    CardResponse delete(Long userId,Long id);
}
