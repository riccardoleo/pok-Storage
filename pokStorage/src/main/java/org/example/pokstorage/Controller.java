package org.controller;

import org.example.pokstorage.CardsRepo;
import org.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album/pok")
public class Controller {

    @Autowired
    private CardsRepo cardsRepo;

    @PutMapping("/NewCard")
    public ResponseEntity<Card> addNewCard(@RequestBody Card newCard) {
        Card savedCard = cardsRepo.save(newCard);
        return ResponseEntity.ok(savedCard);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Controller is working");
    }

}
