package com.atchyut.dev.recipebook.repository;

import com.atchyut.dev.recipebook.model.Recipe;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBookRepository extends ReactiveCrudRepository<Recipe, String> {
}
