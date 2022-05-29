package com.app.bankSystem.enam;

public enum CardType {
    MASTERCARD(5), VISA(4), AMERICAN_EXPRESS(3);

    private final int i;

    CardType(int i) {
        this.i = i;
    }

    public int getNumberOfType(){
        return i;
    }

}
