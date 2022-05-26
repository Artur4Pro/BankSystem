package com.app.bankSystem.service;

import com.app.bankSystem.entity.Account;
import com.app.bankSystem.entity.IBAN;
import com.app.bankSystem.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepo accountRepo;

    AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void createAccount(Account account) {
        account.setIban(IBAN.ibanGenerator(account.getIssuer()));
        accountRepo.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepo.delete(accountRepo.findById(id).get());
    }

    public void updateAccount(Long id, Account account) {
        Account find = accountRepo.findById(id).get();
        find.setAccountBalance(account.getAccountBalance());
        find.setIssuer(account.getIssuer());
        find.setIban(IBAN.ibanGenerator(account.getIssuer()));
        accountRepo.save(find);
    }

}
