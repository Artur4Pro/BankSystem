package com.app.bankSystem.util;

public class CvcCodeGenerator {
    public static String cvcCodeGenerator(){
        return String.valueOf((int) Math.random() * 900) + 100;
    }
}
