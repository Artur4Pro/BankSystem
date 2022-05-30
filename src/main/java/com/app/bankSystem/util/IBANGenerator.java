package com.app.bankSystem.util;

import com.app.bankSystem.entity.Issuer;
import org.springframework.stereotype.Component;

@Component
public class IBANGenerator {
    public  String ibanGenerator(Issuer issuer) {
        return String.valueOf(issuer.getAddress().getCountryCode() + issuer.getBankCode() + issuer.getBranchCode());
    }
}
