package com.atchyut.dev.recipebook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
@ToString
public class Recipe {

    public Recipe(String name, String image, String category, String label
            , String price, String description){
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
        this.label = label;
    }


    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private int id;

    @Field
    private String name;
    @Field
    private String image;
    @Field
    private String category;
    @Field
    private String label;
    @Field
    private String price;
    @Field
    private String description;

}
