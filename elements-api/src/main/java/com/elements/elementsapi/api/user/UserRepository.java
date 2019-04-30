package com.elements.elementsapi.api.user;

import com.arangodb.springframework.repository.ArangoRepository;
import com.elements.elementscommon.domain.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ArangoRepository<User, String> {
}
