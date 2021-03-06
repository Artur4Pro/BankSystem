package com.app.bankSystem.service;

import com.app.bankSystem.entity.Account;
import com.app.bankSystem.entity.Address;
import com.app.bankSystem.entity.CardHolder;
import com.app.bankSystem.repo.AccountRepo;
import com.app.bankSystem.repo.AddressRepo;
import com.app.bankSystem.repo.CardHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardHolderService {
    @Autowired
    CardHolderRepo cardHolderRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    AccountRepo accountRepo;

    public void createCardHolder(CardHolder cardHolder) {
        Address address = addressRepo.findAddressByCountryCodeAndCityAndStreetAndBuildingAndHomeAndZip(
                cardHolder.getAddress().getCountryCode(), cardHolder.getAddress().getCity(),
                cardHolder.getAddress().getStreet(), cardHolder.getAddress().getBuilding(),
                cardHolder.getAddress().getHome(), cardHolder.getAddress().getZip());
        if (address!=null){
            cardHolder.setAddress(address);
        }
        cardHolderRepo.save(cardHolder);
    }

    public void updateCardHolder(Long id, CardHolder cardHolder) {
        CardHolder find = cardHolderRepo.findById(id).get();
        find.setName(cardHolder.getName());
        find.setSurname(cardHolder.getSurname());
        find.setDateOfBirth(cardHolder.getDateOfBirth());
        find.setPhoneNumber(cardHolder.getPhoneNumber());
        find.setAddress(cardHolder.getAddress());
        cardHolderRepo.save(find);
    }

    public void deleteCardHolder(Long id) {
        cardHolderRepo.delete(cardHolderRepo.getById(id));
    }

    public CardHolder findCardHolderById(Long id) {
        return cardHolderRepo.findById(id).get();
    }

    public void transferToCard(Long amount, String fromCardNumber, String toCardNumber) {

    }

    public void transferToAccount(Long amount, String fromCardNumber, String IBAN) {
    }


}
