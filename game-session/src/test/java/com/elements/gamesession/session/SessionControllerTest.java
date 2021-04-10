package com.elements.gamesession.session;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
class SessionControllerTest extends WebSocketTest {
    @Test
    void shouldNotConnectWithoutLoginToken() {
        assertThrows(ExecutionException.class, this::connect);
    }

    @Test
    @SneakyThrows
    void shouldConnect() {
        authenticatedConnect();
        subscribe();

        session.send("/session/test", "TestMan".getBytes());
        assertEquals("Hello 'TestMan'!", blockingQueue.poll(1, SECONDS));
    }

}
