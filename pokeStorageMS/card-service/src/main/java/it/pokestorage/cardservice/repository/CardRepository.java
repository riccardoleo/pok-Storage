package it.pokestorage.cardservice.repository;
import it.pokestorage.cardservice.card.*;
import org.springframework.data.repository.CrudRepository;

import javax.smartcardio.Card;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Long> {
    Optional<Card> findById(long id);
}
