package com.debuggeando_ideas.util_function;

import java.util.function.Function;

public class FunctionExample1 {
    static Function<Integer, Integer> multiply = a -> a * 5;
    static Function<Integer, Integer> add = a -> a + 5;
    static Function<Integer, Integer> subtract = a -> a - 5;
    static Function<Integer, Integer> divide = a -> a / 5;

    static Function<Integer, Integer> addAndThenMultyply = add.andThen(multiply);
    static Function<Integer, Integer> addComposeMultiply = add.compose(multiply);

    Function<Integer,Integer> prueba = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return 0;
        }
    };

    public static void main(String[] args) {
        System.out.println("Result of multiply: " + multiply.apply(5));
        System.out.println("Result of add: " + add.apply(5));
        System.out.println("Result of subtract: " + subtract.apply(5));
        System.out.println("Result of divide: " + divide.apply(5));
        System.out.println("Result of add and then multiply: " + addAndThenMultyply.apply(5));
        System.out.println("Result of add compose multiply: " + addComposeMultiply.apply(5));
    }
}
