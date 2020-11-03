package com.elements.gamesession.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

@Slf4j
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    private static final String SPRING_SESSION_ID_ATTR_NAME = "SPRING.SESSION.ID";
    private static final String SERVLET_SESSION_ID_NAME = "sessionId";

    @Override
    public boolean beforeHandshake(
            @NotNull ServerHttpRequest request,
            @NotNull ServerHttpResponse response,
            @NotNull WebSocketHandler wsHandler,
            @NotNull Map<String, Object> attributes
    ) throws Exception {
        super.beforeHandshake(request, response, wsHandler, attributes);

        if (attributes.containsKey(HTTP_SESSION_ID_ATTR_NAME)) {
            attributes.put(SPRING_SESSION_ID_ATTR_NAME, attributes.get(HTTP_SESSION_ID_ATTR_NAME));
            attributes.put(SERVLET_SESSION_ID_NAME, attributes.get(HTTP_SESSION_ID_ATTR_NAME));
        }
        return true;
    }

    @Override
    public boolean isCreateSession() {
        return true;
    }
}
