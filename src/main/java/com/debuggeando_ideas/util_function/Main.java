package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Function<String, String> funcion = String::toUpperCase;
        BiFunction<String, String, String> funcion2 = String::concat;
        Predicate<String> predicate = String::isEmpty;
    }
}
