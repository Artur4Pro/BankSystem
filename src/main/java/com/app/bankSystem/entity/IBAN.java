package com.app.bankSystem.entity;

public class IBAN {
    public static String ibanGenerator(Issuer issuer) {
        return String.valueOf(issuer.getAddress().getCountryCode() + issuer.getBankCode() + issuer.getBranchCode());
    }
}
