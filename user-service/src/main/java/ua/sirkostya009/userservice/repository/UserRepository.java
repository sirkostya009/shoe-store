package ua.sirkostya009.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.sirkostya009.userservice.dao.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
