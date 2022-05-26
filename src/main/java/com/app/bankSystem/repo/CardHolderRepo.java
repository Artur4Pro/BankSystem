package com.app.bankSystem.repo;

import com.app.bankSystem.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHolderRepo extends JpaRepository<CardHolder, Long> {
}
