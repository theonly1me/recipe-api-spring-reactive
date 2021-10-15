package com.atchyut.dev.recipebook.controller;

import com.atchyut.dev.recipebook.model.Recipe;
import com.atchyut.dev.recipebook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/")
public class RecipeController {

    @Autowired
    RecipeService service;

    @GetMapping("/")
    public Flux<Recipe> getAllRecipes(){
        return service.getAllRecipes();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipe> createRecipe(@RequestBody Recipe recipe){
        return service.createRecipe(recipe);
    }

    @GetMapping("/{id}/show")
    public ResponseEntity<String> getRecipeImage(@PathVariable String id){
        return new ResponseEntity<String>(service.getRecipeImage(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Mono<Recipe> getSingleRecipe(@PathVariable String id){
        return service.getSingleRecipe(id);
    }


}
