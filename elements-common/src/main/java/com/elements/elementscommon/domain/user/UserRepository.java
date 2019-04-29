package com.elements.elementscommon.domain.user;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ArangoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
