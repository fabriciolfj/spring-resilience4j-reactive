package com.github.fabriciolfj.server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommended")
public class RecomendacaoController {

    @GetMapping
    public Mono<String> ingrediantesList() {
        return Mono.just("Arroz, Feijao, Cereais");
    }
}
