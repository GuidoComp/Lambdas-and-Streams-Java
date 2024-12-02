package com.debuggeando_ideas.reference_methods;

import java.util.function.BiPredicate;

public class ArbitrayMethodReference {
    public static void main(String[] args) {
//        BiPredicate<String, String> equals = (a, b) -> a.equals(b);
        BiPredicate<String, String> equals = String::equals;
        boolean isEqual = equals.test("a", "a");
        System.out.println(isEqual);
    }
}
