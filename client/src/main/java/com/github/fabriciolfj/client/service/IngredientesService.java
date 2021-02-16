package com.github.fabriciolfj.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IngredientesService {

    private final Logger logger = LoggerFactory.getLogger(IngredientesService.class);

    private final WebClient webClient;
    private final ReactiveCircuitBreaker readingListCircuitBreaker;

    public IngredientesService(ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.readingListCircuitBreaker = circuitBreakerFactory.create("recommended");
        this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    public Mono<String> ingredientesList() {
        return readingListCircuitBreaker
                .run(webClient.get().uri("/recommended")
                .retrieve()
                .bodyToMono(String.class), throwable -> {
                    logger.error("Details: {}", throwable.getMessage());
                    return Mono.just("Sem itens");
                });
    }

}
