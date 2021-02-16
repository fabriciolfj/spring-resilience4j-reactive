package com.github.fabriciolfj.client.api;

import com.github.fabriciolfj.client.service.IngredientesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/basics")
public class IngredientesController {

    private final IngredientesService ingredientesService;

    public IngredientesController(final IngredientesService ingredientesService) {
        this.ingredientesService = ingredientesService;
    }

    @GetMapping
    public Mono<String> toCook() {
        return ingredientesService.ingredientesList();
    }
}
