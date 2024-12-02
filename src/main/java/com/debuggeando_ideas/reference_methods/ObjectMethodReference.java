package com.debuggeando_ideas.reference_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ObjectMethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        IntStream range = IntStream.range(0, 10);
//        range.forEach(i -> numbers.add(i));
        range.forEach(numbers::add);
        System.out.println(numbers);

    }
}
