package com.app.bankSystem.repo;

import com.app.bankSystem.enam.CountryCode;
import com.app.bankSystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
    Address findAddressByCountryCodeAndCityAndStreetAndBuildingAndHomeAndZip(CountryCode countryCode, String city, String street, String building, String home, String zip);
}
