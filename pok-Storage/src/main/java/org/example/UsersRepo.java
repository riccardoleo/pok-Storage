package org.example;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface UsersRepo extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
