package com.app.bankSystem.util;

import org.springframework.stereotype.Component;

@Component
public class CvcCodeGenerator {
    public String cvcCodeGenerator(){
        return String.valueOf((int) ((Math.random()*900)+100));
    }
}
