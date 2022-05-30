package com.app.bankSystem.service;

import com.app.bankSystem.enam.CardStatusType;
import com.app.bankSystem.entity.Card;
import com.app.bankSystem.repo.CardRepo;
import com.app.bankSystem.util.*;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private CardRepo cardRepo;
    private CardNumberGenerator cardNumberGenerator;
    private CvcCodeGenerator cvcCodeGenerator;
    private ExpirationDateGenerator expirationDateGenerator;
    private PinGenerator pinGenerator;

    CardService(CardRepo cardRepo, CardNumberGenerator cardNumberGenerator, CvcCodeGenerator cvcCodeGenerator, ExpirationDateGenerator expirationDateGenerator, PinGenerator pinGenerator) {
        this.cardRepo = cardRepo;
        this.cardNumberGenerator = cardNumberGenerator;
        this.cvcCodeGenerator = cvcCodeGenerator;
        this.expirationDateGenerator = expirationDateGenerator;
        this.pinGenerator = pinGenerator;
    }

    public void createCard(Card card) {
        card.setCardNumber(cardNumberGenerator.cardNumberGenerator(card, card.getIssuer()));
        card.setCvcCode(cvcCodeGenerator.cvcCodeGenerator());
        card.setExpirationDate(expirationDateGenerator.expirationDateGenerator());
        card.setPin(pinGenerator.encodedString());
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
