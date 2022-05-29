package com.app.bankSystem.controller;

import com.app.bankSystem.entity.Account;
import com.app.bankSystem.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @DeleteMapping("/account/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/account/update/{id}")
    public void updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        accountService.updateAccount(id, account);
    }


}
