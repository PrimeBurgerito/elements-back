package com.elements.gamesession.config.websocket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.Session;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfiguration extends AbstractSessionWebSocketMessageBrokerConfigurer<Session> {
    @Lazy
    private final TokenHandshakeHandler tokenHandshakeHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/session");
        config.enableSimpleBroker("/state");
    }

    @Override
    public void configureStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/start-session")
                .addInterceptors(new WebSocketHandshakeInterceptor())
                .setHandshakeHandler(tokenHandshakeHandler)
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
