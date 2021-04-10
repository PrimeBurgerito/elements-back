package com.elements.gamesession.session;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.concurrent.TimeUnit.SECONDS;

@Import(AuthenticatedUserTestHelper.class)
public abstract class WebSocketTest {
    private static final String WEBSOCKET_URI = "ws://localhost:7778/start-session";
    private static final String WEBSOCKET_TOPIC = "/state";

    private WebSocketStompClient webSocketStompClient;
    protected BlockingQueue<String> blockingQueue;
    protected StompSession session;

    @Autowired
    private AuthenticatedUserTestHelper authenticatedUserTestHelper;

    @BeforeEach
    public void setup() {
        blockingQueue = new LinkedBlockingDeque<>();
        var transport = new WebSocketTransport(new StandardWebSocketClient());
        var sockJsClient = new SockJsClient(List.of(transport));
        webSocketStompClient = new WebSocketStompClient(sockJsClient);
    }

    @SneakyThrows
    protected void connect() {
        session = webSocketStompClient.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
    }

    @SneakyThrows
    protected void authenticatedConnect() {
        String uri = WEBSOCKET_URI + "?access_token=" + authenticatedUserTestHelper.getJwt();
        session = webSocketStompClient.connect(uri, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
    }

    protected void subscribe() {
        session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());
    }


    private class DefaultStompFrameHandler implements StompFrameHandler {
        @NotNull
        @Override
        public Type getPayloadType(@NotNull StompHeaders stompHeaders) {
            return byte[].class;
        }

        @Override
        public void handleFrame(@NotNull StompHeaders stompHeaders, Object o) {
            blockingQueue.offer(new String((byte[]) o));
        }
    }
}
