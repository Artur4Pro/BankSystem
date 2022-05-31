package com.app.bankSystem.service;

import com.app.bankSystem.entity.Account;
import com.app.bankSystem.util.IBANGenerator;
import com.app.bankSystem.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private IBANGenerator ibanGenerator;

    public void createAccount(Account account) {
        account.setIban(ibanGenerator.ibanGenerator(account.getIssuer()));
        accountRepo.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepo.delete(accountRepo.findById(id).get());
    }

    public void updateAccount(Long id, Account account) {
        Account find = accountRepo.findById(id).get();
        find.setAccountBalance(account.getAccountBalance());
        find.setIssuer(account.getIssuer());
        find.setIban(ibanGenerator.ibanGenerator(account.getIssuer()));
        accountRepo.save(find);
    }

}
