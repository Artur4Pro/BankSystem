package com.app.bankSystem.controller;

import com.app.bankSystem.entity.Card;
import com.app.bankSystem.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CardController {
    private CardService cardService;

    CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    public void createdCard(@RequestBody Card card) {
        cardService.createCard(card);
    }

    @GetMapping("/cards/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Card findCardById(@PathVariable("id") Long id) {
        return cardService.findCardById(id);
    }

    @PutMapping("/cards/activate/{id}")
    public void activateCard(@PathVariable("id") Long id) {
        cardService.activateCard(id);
    }

    @PutMapping("/cards/block/{id}")
    public void blockCard(@PathVariable("id") Long id) {
        cardService.blockCard(id);
    }


}
