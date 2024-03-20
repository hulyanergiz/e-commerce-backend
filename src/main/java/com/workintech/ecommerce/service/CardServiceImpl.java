package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CardResponse;
import com.workintech.ecommerce.entity.Card;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.CardRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    private final UserService userService;

    @Override
    public List<CardResponse> findAllForUser(Long userId) {
        return DtoConverter.cardResponseListConverter(cardRepository.findCardsByUserId(userId));
    }

    @Override
    public Card findById(Long id) {
        Optional<Card> optionalCard=cardRepository.findById(id);
        if(optionalCard.isPresent()){
            return optionalCard.get();
        }
        throw new EcommerceException("Card is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse getById(Long id) {
        return DtoConverter.cardResponseConverter(findById(id));
    }

    @Override
    public CardResponse save(Long userId, Card card) {
        User user=userService.findById(userId);
        if(user!=null){
            card.getUsers().add(user);
            return DtoConverter.cardResponseConverter(cardRepository.save(card));
        }
        throw new EcommerceException("User is not found with id: "+userId,HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse delete(Long userId, Long id) {
        User user=userService.findById(userId);
        Card cardToDelete=findById(id);
        if(cardToDelete.getUsers().contains(user)){
            cardToDelete.getUsers().remove(user);
            cardRepository.delete(cardToDelete);
            return DtoConverter.cardResponseConverter(cardToDelete);
        }
        throw new EcommerceException("Card with id "+id+" is not found in cards of user with id: "+userId,HttpStatus.NOT_FOUND);
    }
}
