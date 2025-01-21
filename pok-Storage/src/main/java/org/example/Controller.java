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

    @GetMapping("/GetCard/allCards")
    public List<Card> all() {
        return cardsRepo.findAll();
    }

    @GetMapping("/GetCard/{id}")
    public ResponseEntity<Card> findById(@PathVariable String id) {
        Optional<Card> card = cardsRepo.findById(id);
        return card.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/PostCard")
    public ResponseEntity<Card> postCard(@RequestBody Card card) {
        Card savedCard = cardsRepo.save(card);
        return ResponseEntity.ok(savedCard);
    }

    @PutMapping("/NewCard")
    public ResponseEntity<Card> newCard(@RequestBody Card card) {
        Card updatedCard = cardsRepo.save(card);
        return ResponseEntity.ok(updatedCard);
    }
}
