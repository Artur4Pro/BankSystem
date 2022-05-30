package com.app.bankSystem.entity;

import com.app.bankSystem.util.IBANGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double accountBalance;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Issuer issuer;
    private String iban ;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Account() {
    }

    public Account(Issuer issuer, double accountBalance) {
        this.issuer = issuer;
        this.accountBalance = accountBalance;
    }

    public String getIban() {
        return iban;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.accountBalance, accountBalance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(issuer, account.issuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, issuer, accountBalance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban=" + iban +
                ", issuer=" + issuer +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
