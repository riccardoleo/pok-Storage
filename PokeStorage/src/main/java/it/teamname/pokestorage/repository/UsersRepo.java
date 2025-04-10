package it.teamname.pokestorage.repository;

import it.teamname.pokestorage.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface UsersRepo extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
