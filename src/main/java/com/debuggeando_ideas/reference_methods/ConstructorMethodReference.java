package com.debuggeando_ideas.reference_methods;

import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
//        Supplier<MyObject> myObjectSupplier = () -> new MyObject();
        Supplier<MyObject> myObjectSupplier = MyObject::new;
        System.out.println(myObjectSupplier.get());
    }

}
