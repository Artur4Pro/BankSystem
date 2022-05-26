package com.app.bankSystem.enam;

public enum CardStatusType {
    CREATED(0), ACTIVE(1) , BLOCKED(2);

    private final int i;

    CardStatusType(int i) {
        this.i = i;
    }
}
