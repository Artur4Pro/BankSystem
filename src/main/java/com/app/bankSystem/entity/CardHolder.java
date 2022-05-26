package com.app.bankSystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CardHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private Date dateOfBirth;

    private String phoneNumber;

    @OneToMany(mappedBy = "cardHolder")
    private Set<Card> cards = new HashSet<>();

    @OneToMany(mappedBy = "cardHolder")
    private Set<Account> accounts = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
