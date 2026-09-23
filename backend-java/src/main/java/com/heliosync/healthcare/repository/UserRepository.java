package com.heliosync.healthcare.repository;

import com.heliosync.healthcare.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    java.util.Optional<User> findByEmail(String email);
}
