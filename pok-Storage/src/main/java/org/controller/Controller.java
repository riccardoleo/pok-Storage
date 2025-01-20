package org.controller;

import org.model.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final Card card;

    Controller(Card card){
        this.card = card;
    }

    @GetMapping("/GetCard/allCards")
    List<Card> all() {
        return card.findAll();
    }

    @GetMapping("/GetCard/{id}")
    Card findById(@PathVariable int id) {
        return card;
    }

    @GetMapping("/GetCard/{cardCode}")
    Card findByCardCode(@PathVariable String cardCode) {
        return card;
    }

    @GetMapping("/GetCard/{generation}")
    Card findByGeneration(@PathVariable String generation) {
        return card;
    }

    @GetMapping("/GetCard/{name}")
    Card findByName(@PathVariable String name) {
        return card;
    }

    @PostMapping("/PostCard")
    Card postCard(@RequestBody Card card) {
        return card;
    }

    @PutMapping("/PutCard")
    Card putCard(@RequestBody Card card) {
        return card;
    }


}
