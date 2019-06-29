/*
package com.elements.gamesession.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.session.Session;

@Configuration
static class WebSocketHandlersConfig {

    @Bean
    public WebSocketConnectHandler<Session> webSocketConnectHandler(SimpMessageSendingOperations messagingTemplate,
                                                                    ActiveWebSocketUserRepository repository) {
        return new WebSocketConnectHandler<Session>(messagingTemplate, repository);
    }

    @Bean
    public WebSocketDisconnectHandler<Session> webSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate,
                                                                          ActiveWebSocketUserRepository repository) {
        return new WebSocketDisconnectHandler<Session>(messagingTemplate, repository);
    }
}
*/
