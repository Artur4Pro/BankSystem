package com.app.bankSystem.util;

import com.app.bankSystem.entity.Issuer;

public class IBANGenerator {
    public static String ibanGenerator(Issuer issuer) {
        return String.valueOf(issuer.getAddress().getCountryCode() + issuer.getBankCode() + issuer.getBranchCode());
    }
}
