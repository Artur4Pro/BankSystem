package com.app.bankSystem.enam;

public enum Status {
    CREATED(0), ACTIVE(1), BLOCKED(2);

    private final int i;

    Status(int i) {
        this.i = i;
    }
}

