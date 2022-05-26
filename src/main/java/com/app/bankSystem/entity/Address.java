package com.app.bankSystem.entity;

import com.app.bankSystem.enam.CountryCode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"countryCode","city","street","building","home","zip"}))
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;
    private String city;
    private String street;
    private String building;
    private String home;
    private String zip;

    @OneToMany(mappedBy = "address")
    Set<CardHolder> cardHolders;

    public Address() {
    }

    public Address(CountryCode countryCode, String city, String street, String building, String home, String zip) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.building = building;
        this.home = home;
        this.zip = zip;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && countryCode == address.countryCode && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(building, address.building) && Objects.equals(home, address.home) && Objects.equals(zip, address.zip) && Objects.equals(cardHolders, address.cardHolders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryCode, city, street, building, home, zip, cardHolders);
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryCode=" + countryCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", home='" + home + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
