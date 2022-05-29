package com.app.bankSystem.util;

import java.sql.Date;
import java.time.LocalDate;

public class ExpirationDateGenerator {
    public static Date expirationDateGenerator() {
        return Date.valueOf(LocalDate.now().plusYears(4L));
    }
}
