package com.app.bankSystem.repo;

import com.app.bankSystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address , Long> {
}
