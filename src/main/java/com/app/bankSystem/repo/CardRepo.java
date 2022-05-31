package com.app.bankSystem.repo;

import com.app.bankSystem.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
    Card findCardByCardNumber(String cardNumber);
}
