package com.elements.gamesession.session;

import com.elements.elementscommon.config.security.JwtUtils;
import com.elements.elementscommon.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@TestComponent
@RequiredArgsConstructor
public class AuthenticatedUserTestHelper {
    private static final String USERNAME = "test_name";
    private static final String PASSWORD = "test_password";

    private final MongoTemplate mongoTemplate;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Getter
    private String jwt;

    @PostConstruct
    public void afterInit() {
        User user = mongoTemplate.findOne(query(where("username").is(USERNAME)), User.class);
        if (user == null) {
            user = new User();
            user.setUsername(USERNAME);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user = mongoTemplate.insert(user);
        }
        jwt = jwtUtils.generateJwtToken(new TestingAuthenticationToken(user, null));
    }
}
