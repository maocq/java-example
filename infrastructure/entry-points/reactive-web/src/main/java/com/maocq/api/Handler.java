package com.maocq.api;

import com.maocq.usecase.getpost.GetPostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final GetPostUseCase getPostUseCase;

    public Mono<ServerResponse> listenGETHello(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Hello");
    }

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        //getPostUseCase.get();
        return ServerResponse.ok().bodyValue("Use case");
    }
}
