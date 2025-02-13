package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/album/pok")
public class Controller {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private CardsRepo cardsRepo;
    @Autowired
    private UsersRepo usersRepo;


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


    ////////////////////////////////////////////////////////
    //////////////// LOGIN E REGISTER //////////////////////

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (usersRepo.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username già esistente");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);
        return ResponseEntity.ok("Registrazione completata");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        System.out.println("Login - Username ricevuto: " + user.getUsername());
        System.out.println("Login - Password ricevuta: " + user.getPassword());

        var existingUser = usersRepo.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            String storedPassword = existingUser.get().getPassword();
            System.out.println("Login - Password salvata nel DB: " + storedPassword);

            boolean match = encoder.matches(user.getPassword(), storedPassword);
            System.out.println("Login - Confronto password: " + match);

            if (match) {
                return ResponseEntity.ok(Map.of("message", "Login riuscito"));
            } else {
                return ResponseEntity.status(401).body(Map.of("message", "Password errata"));
            }
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Utente non trovato"));
        }
    }


}