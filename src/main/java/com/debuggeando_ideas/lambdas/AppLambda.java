package com.debuggeando_ideas.lambdas;

import java.util.List;

public class AppLambda {
    public static void main(String[] args) {
        List<String> countries = List.of("Mexico", "USA", "Canada", "Brazil", "Argentina");
        countries.forEach(country -> System.out.println(country));
    }
}
