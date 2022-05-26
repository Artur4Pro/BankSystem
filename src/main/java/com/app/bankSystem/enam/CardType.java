package com.app.bankSystem.enam;

public enum CardType {
    MASTERCARD(0), VISA(1), AMERICAN_EXPRESS(2), DISCOVER(3);

    private final int i;

    CardType(int i) {
        this.i = i;
    }
}
