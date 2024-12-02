package com.debuggeando_ideas.util_function;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    static BiPredicate<String, String> myEquals = (a, b) -> a.concat(b).equals("HelloWorld");

    public static void main(String[] args) {
        System.out.println(myEquals.test("Hello", "World"));
    }

}
