package com.maocq.usecase.getpost;

import com.maocq.model.post.Post;
import com.maocq.model.post.gateways.PostGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetPostUseCase {

    private final PostGateway postGateway;

    public Mono<Post> get() {
        return postGateway.get();
    }
}
