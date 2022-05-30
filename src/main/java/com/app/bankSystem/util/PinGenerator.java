package com.app.bankSystem.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class PinGenerator {
    private String pinGenerator() {
        return String.valueOf((int) ((Math.random() * 9000) + 1000));
    }

    public String encodedString() {
        return Base64.getEncoder().encodeToString(pinGenerator().getBytes());
    }
}
