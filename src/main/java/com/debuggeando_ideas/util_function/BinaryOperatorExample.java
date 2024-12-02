package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {
        BiFunction<String, String, String> normalizer = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizer.apply("Hello", "World"));

        BinaryOperator<String> normalizer2 = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizer2.apply("Hello", "World"));
    }
}
