package com.app.bankSystem.util;

import com.app.bankSystem.enam.CardType;
import com.app.bankSystem.entity.Card;
import com.app.bankSystem.entity.Issuer;
import org.springframework.stereotype.Component;

@Component
public class CardNumberGenerator {
    private String cardFirstNumberGenerator(Card cardType, Issuer issuer) {
        return String.valueOf(cardType.getCardType().getNumberOfType()+ issuer.getBankCode());
    }

    private String cardOtherNumberGenerator(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i + string.length() < 16; i++) {
            stringBuilder.append((int) (Math.random() * 10));

        }
        return String.valueOf(stringBuilder);
    }

    public String cardNumberGenerator(Card cardType, Issuer issuer) {
        String cardNumber = cardFirstNumberGenerator(cardType, issuer);
        return cardNumber + cardOtherNumberGenerator(cardNumber);
    }
}
