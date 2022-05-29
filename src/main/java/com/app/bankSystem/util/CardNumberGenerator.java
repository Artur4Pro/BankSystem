package com.app.bankSystem.util;

import com.app.bankSystem.enam.CardType;
import com.app.bankSystem.entity.Card;
import com.app.bankSystem.entity.Issuer;

public class CardNumberGenerator {
    private String cardFirstNumberGenerator(Card card, Issuer issuer){
        return String.valueOf(card.getCardType().getNumberOfType() + issuer.getBankCode());
    }

    private String cardOtherNumberGenerator(){
        String number =
    }

    public String cardNumberGenerator(){
        cardNumberGenerator()
    }
}
