package com.atchyut.dev.recipebook.config;

import com.atchyut.dev.recipebook.repository.RecipeBookRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = RecipeBookRepository.class)
public class ReactiveMongoConfiguration {

}
