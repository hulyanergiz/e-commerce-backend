package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CardResponse;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @GetMapping("/user/{userId}")
    public List<CardResponse> findAllForUser(@PathVariable Long userId){
        return cardService.findAllForUser(userId);
    }

    @GetMapping("/{id}")
    public CardResponse getById(@PathVariable Long id){
        return cardService.getById(id);
    }

    @PostMapping("/user/{userId}")
    public CardResponse save(@PathVariable Long userId, @RequestBody Card card){
        return cardService.save(userId,card);
    }

    @DeleteMapping("/user/{userId}/{id}")
    public CardResponse delete(@PathVariable Long userId,@PathVariable Long id){
        return cardService.delete(userId, id);
    }
}
