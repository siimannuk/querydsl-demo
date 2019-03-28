package com.siimannuk.querydsldemo.superhero;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class SuperheroDto {
    private Long id;
    private String name;
    private String gender;
    private String skinColor;
    private String eyeColor;
    private String hairColor;
    private double height;
    private double weight;
    private String alignment;
    private String race;
    private String publisher;
    private Set<String> superpowers = new HashSet<>();
}
