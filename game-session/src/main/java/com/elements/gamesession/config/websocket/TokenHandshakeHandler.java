package com.elements.gamesession.config.websocket;

import com.elements.elementscommon.config.security.JwtUtils;
import com.elements.elementscommon.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Component
@RequiredArgsConstructor
public class TokenHandshakeHandler extends DefaultHandshakeHandler {
    private static final String TOKEN_KEY = "access_token=";
    private final JwtUtils jwtUtils;
    private final MongoTemplate mongoTemplate;

    @Override
    protected Principal determineUser(
            @NotNull ServerHttpRequest request,
            @NotNull WebSocketHandler wsHandler,
            @NotNull Map<String, Object> attributes
    ) {
        if (request.getURI().getQuery().startsWith(TOKEN_KEY)) {
            String token = request.getURI().getQuery().substring(TOKEN_KEY.length());
            return getUserFromToken(token);
        }
        return super.determineUser(request, wsHandler, attributes);
    }

    private Principal getUserFromToken(String token) {
        String username = jwtUtils.getUserNameFromJwtToken(token);
        User user = mongoTemplate.findOne(query(where("username").is(username)), User.class);
        return new UsernamePasswordAuthenticationToken(user, null, user == null ? null : user.getAuthorities());
    }
}
