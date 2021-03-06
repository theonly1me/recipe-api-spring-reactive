package com.atchyut.dev.recipebook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfiguration {

    @Value("${base.uri}")
    String uri;

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(uri)
                .defaultHeader(HttpHeaders.CONTENT_TYPE
                        , MediaType.APPLICATION_JSON_VALUE).build();
    }
}
