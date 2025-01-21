package org.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardsRepo extends MongoRepository<Card, String> {

}
