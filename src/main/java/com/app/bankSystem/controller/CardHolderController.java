package com.app.bankSystem.controller;

import com.app.bankSystem.entity.CardHolder;
import com.app.bankSystem.service.CardHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CardHolderController {

    @Autowired
    private CardHolderService cardHolderService;

    @PostMapping("/cardHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCardHolder(@RequestBody CardHolder cardHolder) {
        cardHolderService.createCardHolder(cardHolder);
    }

    @PutMapping("/cardHolder/update/{id}")
    public void updateCardHolder(@PathVariable("id") Long id, @RequestBody CardHolder cardHolder) {
        cardHolderService.updateCardHolder(id, cardHolder);
    }

    @DeleteMapping("/cardHolder/delete/{id}")
    public void deleteCardHolder(@PathVariable("id") Long id) {
        cardHolderService.deleteCardHolder(id);
    }

    @GetMapping("/cardHolder/find/{id}")
    public CardHolder findCardHolderById(@PathVariable("id") Long id) {
        return cardHolderService.findCardHolderById(id);
    }
}
