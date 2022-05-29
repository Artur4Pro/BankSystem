package com.app.bankSystem.util;

import java.util.Base64;

public class PinGenerator {
    private static String pinGenerator() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

    public static String encodedString() {
        return Base64.getEncoder().encodeToString(pinGenerator().getBytes());
    }
}
