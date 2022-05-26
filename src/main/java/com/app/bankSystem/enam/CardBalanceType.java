package com.app.bankSystem.enam;

public enum CardBalanceType {
    CREDIT(0), DEBIT(1), CHARGE(2), ATM(3);

    private final int i;

    CardBalanceType(int i) {
        this.i = i;
    }
}
