package com.app.bankSystem.entity;

import com.app.bankSystem.enam.CardBalanceType;
import com.app.bankSystem.enam.CardStatusType;
import com.app.bankSystem.enam.CardType;
import com.app.bankSystem.util.CardNumberGenerator;
import com.app.bankSystem.util.CvcCodeGenerator;
import com.app.bankSystem.util.ExpirationDateGenerator;
import com.app.bankSystem.util.PinGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.ORDINAL)
    private CardType cardType;
    @Enumerated(EnumType.ORDINAL)
    private CardBalanceType cardBalanceType;
    @Enumerated(EnumType.ORDINAL)
    private CardStatusType cardStatusType;
    private long balance;
    private String cardNumber;
    private Date expirationDate;
    private String cvcCode;
    @JsonIgnore
    private String pin;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Issuer issuer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Card() {
    }

    public Card(CardType cardType, CardBalanceType cardBalanceType, Issuer issuer, long balance) {
        this.cardType = cardType;
        this.cardBalanceType = cardBalanceType;
        this.issuer = issuer;
        this.balance = balance;
        this.cardStatusType = CardStatusType.CREATED;
    }


    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardBalanceType getCardBalanceType() {
        return cardBalanceType;
    }

    public void setCardBalanceType(CardBalanceType cardBalanceType) {
        this.cardBalanceType = cardBalanceType;
    }

    public CardStatusType getCardStatusType() {
        return cardStatusType;
    }

    public void setCardStatusType(CardStatusType cardStatusType) {
        this.cardStatusType = cardStatusType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public String getPin() {
        return pin;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;

    }

    public Issuer getIssuer() {
        return issuer;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvcCode(String cvcCode) {
        this.cvcCode = cvcCode;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return balance == card.balance && cardType == card.cardType && cardBalanceType == card.cardBalanceType && cardStatusType == card.cardStatusType && Objects.equals(issuer, card.issuer) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(cvcCode, card.cvcCode) && Objects.equals(pin, card.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardBalanceType, cardStatusType, issuer, balance, cardNumber, expirationDate, cvcCode, pin);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardType=" + cardType +
                ", cardBalanceType=" + cardBalanceType +
                ", cardStatusType=" + cardStatusType +
                ", issuer=" + issuer +
                ", balance=" + balance +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvcCode='" + cvcCode + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
