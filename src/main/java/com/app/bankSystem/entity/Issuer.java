package com.app.bankSystem.entity;

import com.app.bankSystem.enam.BankType;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bankName;
    private String bankCode;
    @Enumerated(EnumType.ORDINAL)
    private BankType bankType;
    private String branchCode;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "issuer",cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "issuer",cascade = CascadeType.ALL)
    private Set<Account> accounts;

    public Issuer() {
    }

    public Issuer(String bankName, String bankCode, BankType bankType, String branchCode , Address address) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.bankType = bankType;
        this.branchCode = branchCode;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issuer issuer = (Issuer) o;
        return id == issuer.id && Objects.equals(bankName, issuer.bankName) && Objects.equals(bankCode, issuer.bankCode) && bankType == issuer.bankType && Objects.equals(branchCode, issuer.branchCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bankName, bankCode, bankType, branchCode);
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "bankName='" + bankName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankType=" + bankType +
                ", branchCode='" + branchCode +
                '}';
    }
}
