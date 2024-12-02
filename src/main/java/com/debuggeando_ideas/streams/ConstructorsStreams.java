package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorsStreams {
    public static void main(String[] args) {
        Stream<Videogame> myStream = Database.videogames.stream();

        myStream.forEach(System.out::println);

        System.out.println("------------------------------------------------");

        Integer[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> intStream = Arrays.stream(myArray);

        intStream.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        Stream.of("Hello", "World", "Java", "Streams")
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        DoubleStream myDoubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        myDoubleStream.forEach(System.out::println);
    }
}
