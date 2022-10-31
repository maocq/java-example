package com.maocq.consumer;

import com.maocq.model.post.Post;
import com.maocq.model.post.gateways.PostGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestConsumer implements PostGateway {

    private final WebClient client;

    @Override
    public Mono<Post> get() {
        return client
                .get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(PostData.class)
                .map(this::toEntity);
    }

    private Post toEntity(PostData data) {
        return Post.builder().id(data.getId()).title(data.getTitle()).build();
    }
}