package com.app.bankSystem.repo;

import com.app.bankSystem.entity.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuerRepo extends JpaRepository<Issuer,Long> {
}
