package com.debuggeando_ideas.util_function;

import com.debuggeando_ideas.fundamentals.Product;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<Product> productSupplier = () -> new Product("Smartphone", 100.0);

    public static void main(String[] args) {
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());
    }
}
