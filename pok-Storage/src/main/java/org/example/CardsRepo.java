package org.example;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CardsRepo extends MongoRepository<Card, Integer> {

    Optional<Card> findByGeneration(String generation);
}
