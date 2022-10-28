package com.maocq.model.post.gateways;

import com.maocq.model.post.Post;
import reactor.core.publisher.Mono;

public interface PostGateway {

    Mono<Post> get();
}
