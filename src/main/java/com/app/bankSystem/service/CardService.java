package com.app.bankSystem.service;

import com.app.bankSystem.enam.CardStatusType;
import com.app.bankSystem.entity.Card;
import com.app.bankSystem.repo.CardRepo;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private CardRepo cardRepo;

    CardService(CardRepo cardRepo){
        this.cardRepo=cardRepo;
    }

    public void createCard(Card card) {
        cardRepo.save(card);
    }

    public void activateCard(Long id) {
        Card card = cardRepo.findById(id).get();
        card.setCardStatusType(CardStatusType.ACTIVE);
        cardRepo.save(card);
    }

    public void blockCard(Long id) {
        Card card = cardRepo.findById(id).get();
        card.setCardStatusType(CardStatusType.BLOCKED);
        cardRepo.save(card);
    }

    public Card findCardById(Long id) {
        return cardRepo.findById(id).get();
    }

}
