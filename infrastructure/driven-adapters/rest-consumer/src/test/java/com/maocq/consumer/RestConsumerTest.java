package com.maocq.consumer;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public class RestConsumerTest {

    public static final String HOST = "http://localhost:%s/";
    private static MockWebServer server;
    private static int port;

    @BeforeAll
    static void beforeAll() {
        var json = "{\"userId\":1,\"id\":1,\"title\":\"sunt aut facere\",\"body\":\"quia et suscipit recusandae consequuntur\"}";
        server = new MockWebServer();
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .setBody(json));

        port = server.getPort();
    }

    @Test
    void name() {
        var webClient = WebClient.builder().baseUrl(getBaseUrl(port)).build();
        var restConsumer = new RestConsumer(webClient);

        StepVerifier
                .create(restConsumer.get())
                .expectNextMatches(post -> post.getTitle().equals("sunt aut facere"))
                .verifyComplete();
    }

    public static String getBaseUrl(int port) {
        return String.format(HOST, port);
    }

}
