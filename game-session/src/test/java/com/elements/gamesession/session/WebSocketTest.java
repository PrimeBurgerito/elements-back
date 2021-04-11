package com.elements.gamesession.session;

import com.elements.gamesession.helper.AuthenticatedUserTestHelper;
import com.elements.gamesession.helper.GameDataTestHelper;
import com.elements.gamesession.session.resource.GameStateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Import({AuthenticatedUserTestHelper.class, GameDataTestHelper.class})
public abstract class WebSocketTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String WEBSOCKET_URI = "ws://localhost:7778/start-session";
    private static final String WEBSOCKET_TOPIC = "/user/state/game";

    private WebSocketStompClient webSocketStompClient;
    protected BlockingQueue<String> testBlockingQueue;
    protected BlockingQueue<GameStateDTO> gameStateBlockingQueue;

    @Autowired
    protected AuthenticatedUserTestHelper authenticatedUserTestHelper;

    @BeforeEach
    public void setup() {
        testBlockingQueue = new LinkedBlockingDeque<>();
        gameStateBlockingQueue = new LinkedBlockingDeque<>();
        var transport = new WebSocketTransport(new StandardWebSocketClient());
        var sockJsClient = new SockJsClient(List.of(transport));
        webSocketStompClient = new WebSocketStompClient(sockJsClient);
    }

    @SneakyThrows
    protected void connect() {
        webSocketStompClient.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
    }

    @SneakyThrows
    protected StompSession authenticatedConnect() {
        String uri = WEBSOCKET_URI + "?access_token=" + authenticatedUserTestHelper.getJwt();
        return webSocketStompClient.connect(uri, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
    }

    @SneakyThrows
    protected StompSession authenticatedConnect(String username) {
        String uri = WEBSOCKET_URI + "?access_token=" + authenticatedUserTestHelper.getJwtFor(username);
        return webSocketStompClient.connect(uri, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
    }

    protected void testSubscribe(StompSession session) {
        session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());
    }

    protected void setGameStateSubscribe(StompSession session) {
        session.subscribe(WEBSOCKET_TOPIC, new GameStateFrameHandler());
    }


    private class DefaultStompFrameHandler implements StompFrameHandler {
        @NotNull
        @Override
        public Type getPayloadType(@NotNull StompHeaders stompHeaders) {
            return byte[].class;
        }

        @Override
        public void handleFrame(@NotNull StompHeaders stompHeaders, Object o) {
            String offering = new String((byte[]) o);
            log.info("Offering to blocking queue: {}", offering);
            testBlockingQueue.offer(offering);
        }
    }

    private class GameStateFrameHandler implements StompFrameHandler {
        @NotNull
        @Override
        public Type getPayloadType(@NotNull StompHeaders stompHeaders) {
            return byte[].class;
        }

        @Override
        @SneakyThrows
        public void handleFrame(@NotNull StompHeaders stompHeaders, Object o) {
            GameStateDTO offer = objectMapper.readValue((byte[]) o, GameStateDTO.class);
            log.info("Offering to blocking queue: {}", offer);
            gameStateBlockingQueue.offer(offer);
        }
    }
}
