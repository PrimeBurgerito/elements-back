package com.elements.elementscommon.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
