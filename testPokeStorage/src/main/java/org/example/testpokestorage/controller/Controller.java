package org.example.testpokestorage.controller;

import org.example.testpokestorage.repository.UsersRepo;
import org.example.testpokestorage.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/album")
public class Controller {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsersRepo usersRepo;


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
