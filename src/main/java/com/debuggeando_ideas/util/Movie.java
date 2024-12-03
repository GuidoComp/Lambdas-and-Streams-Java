package com.debuggeando_ideas.util;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Movie {
    private String name;
    private Double price;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }
}
