package com.app.bankSystem.repo;

import com.app.bankSystem.entity.Account;
import com.app.bankSystem.entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
