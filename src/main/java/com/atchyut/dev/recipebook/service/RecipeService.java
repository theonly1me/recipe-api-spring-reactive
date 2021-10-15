package com.atchyut.dev.recipebook.service;

import com.atchyut.dev.recipebook.model.Recipe;
import com.atchyut.dev.recipebook.repository.RecipeBookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeService {

    private final RecipeBookRepository repository;
    private WebClient webClient;

    public Flux<Recipe> getAllRecipes() {
        Flux<Recipe> response = webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(Recipe.class);

        Flux<Recipe> result = null;
        List<Recipe> recipesFromDB = repository.findAll().collectList().block();
        if (recipesFromDB != null && recipesFromDB.isEmpty())
            result = repository.saveAll(response);
        else
            result = repository.findAll();

        return result;
    }

    public Mono<Recipe> createRecipe(Recipe recipe){
         return repository.save(recipe);
    }

    public Mono<Recipe> getSingleRecipe(String id) {
    List<Recipe> recipeList = null;
    Mono<Recipe> res = null;
        try{
            recipeList = repository.findAll().collectList().block();
            for(Recipe r : recipeList){
                if(r.getId() == Integer.parseInt(id)){
                    res = Mono.just(r);
                }
            }
        }
        catch(Exception ex) {
            log.info("Invalid ID, {}", ex.getMessage());
        }
        return res;
    }

    public String getRecipeImage(String id) {Flux<Recipe> res = null;
        String imageUri = "";
        List<Recipe> recipeList = null;
        try{
            recipeList = repository.findAll().collectList().block();
            for(Recipe r : recipeList){
                if(r.getId() == Integer.parseInt(id)){
                    imageUri = r.getImage();
                    break;
                }
            }
        }
        catch(Exception ex) {
            log.info("Invalid ID, {}", ex.getMessage());
        }

        return imageUri;
    }
}
