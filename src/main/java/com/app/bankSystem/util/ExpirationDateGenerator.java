package com.app.bankSystem.util;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class ExpirationDateGenerator {
    public  Date expirationDateGenerator() {
        return Date.valueOf(LocalDate.now().plusYears(4L));
    }
}
