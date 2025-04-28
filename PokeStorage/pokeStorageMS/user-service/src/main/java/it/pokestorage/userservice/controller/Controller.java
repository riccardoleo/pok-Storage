package it.pokestorage.userservice.controller;
import it.pokestorage.userservice.model.User;
import it.pokestorage.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Controller {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository usersRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (usersRepo.findByUsername(user.getUsername()).isPresent() && usersRepo.findByEmail(user.getEmail()).isPresent()) {
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<User> userOptional = usersRepo.findById(id);
        if (userOptional.isPresent()) {
            usersRepo.deleteById(id);
            return ResponseEntity.ok("Account eliminato");
        } else {
            return ResponseEntity.badRequest().body("Account non trovato");
        }
    }

    @PatchMapping("/changeUsername/{id}")
    public ResponseEntity<String> changeUserData(@PathVariable Long id, @RequestBody Map<String, String> data) {
        Optional<User> userOpt = usersRepo.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUsername(data.get("username"));
            usersRepo.save(user);
            return ResponseEntity.ok().body("Username aggiornato");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
        }

    }

    @PatchMapping("/changePassword/{id}")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestBody Map<String, String> data) {
        Optional<User> userOpt = usersRepo.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String rawPassword = data.get("password");
            String encodedPassword = encoder.encode(rawPassword);
            user.setPassword(encodedPassword);
            usersRepo.save(user);
            return ResponseEntity.ok().body("Password aggiornato");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
        }
    }

}
