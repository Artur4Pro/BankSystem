package com.app.bankSystem.service;

import com.app.bankSystem.enam.CardStatusType;
import com.app.bankSystem.entity.Card;
import com.app.bankSystem.entity.Issuer;
import com.app.bankSystem.repo.CardRepo;
import com.app.bankSystem.repo.IssuerRepo;
import com.app.bankSystem.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private CardNumberGenerator cardNumberGenerator;
    @Autowired
    private CvcCodeGenerator cvcCodeGenerator;
    @Autowired
    private ExpirationDateGenerator expirationDateGenerator;
    @Autowired
    private PinGenerator pinGenerator;

    @Autowired
    private IssuerRepo issuerRepo;

//    CardService(CardRepo cardRepo, CardNumberGenerator cardNumberGenerator, CvcCodeGenerator cvcCodeGenerator, ExpirationDateGenerator expirationDateGenerator, PinGenerator pinGenerator,IssuerRepo issuerRepo) {
//        this.cardRepo = cardRepo;
//        this.cardNumberGenerator = cardNumberGenerator;
//        this.cvcCodeGenerator = cvcCodeGenerator;
//        this.expirationDateGenerator = expirationDateGenerator;
//        this.pinGenerator = pinGenerator;
//        this.
//    }

    public void createCard(Card card) {
        Issuer issuer = issuerRepo.findIssuerByBankNameAndBankCodeAndBranchCode(card.getIssuer().getBankName(), card.getIssuer().getBankCode(), card.getIssuer().getBranchCode());
        if (issuer != null) {
            card.setIssuer(issuer);
        }

        String cardNumber = cardNumberGenerator.cardNumberGenerator(card, card.getIssuer());
        Card card1 = cardRepo.findCardByCardNumber(cardNumber);
        while (card1 != null) {
            cardNumber = cardNumberGenerator.cardNumberGenerator(card, card.getIssuer());
        }
        card.setCardNumber(cardNumber);

        card.setCvcCode(cvcCodeGenerator.cvcCodeGenerator());
        card.setExpirationDate(expirationDateGenerator.expirationDateGenerator());
        card.setPin(pinGenerator.encodedString());
        card.setCardStatusType(CardStatusType.CREATED);
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
