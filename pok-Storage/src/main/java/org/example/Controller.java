package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album/pok")
public class Controller {

    @Autowired
    private CardsRepo cardsRepo;


    // GET

    @GetMapping("/GetCard/allCards")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardsRepo.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/GetCard/{id}")
    public ResponseEntity<Card> findById(@PathVariable int id) {
        Optional<Card> card = cardsRepo.findById(id);
        return card.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/GetCardByGen/{generation}")
    public ResponseEntity<List<Card>> findByGen(@PathVariable String generation) {
        Optional<Card> card = cardsRepo.findByGeneration(generation);
        if(card.isPresent()) {
            return ResponseEntity.ok(cardsRepo.findAll());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // PUT

    @PutMapping("/NewCard")
    public ResponseEntity<Card> newCard(@RequestBody Card card) {
        Card updatedCard = cardsRepo.save(card);
        return ResponseEntity.ok(updatedCard);
    }


    // DELETE

    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<Card> deleteCard(@PathVariable int id) {
        Card card = cardsRepo.findById(id).orElse(null);
        cardsRepo.delete(card);
        return ResponseEntity.ok(card);
    }
}