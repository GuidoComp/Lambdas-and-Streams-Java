package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

//        countOperator(videogames);
//        forEachOperator(videogames);
//        anyMatchOperator(videogames);
//        allMatchOperator(videogames);
//        noneMatchOperator(videogames);
//        findFirstOperator(videogames);
//        findAnyOperator(videogames);
//        reduceOperator(videogames);
        minOperator(videogames);
    }
    static void countOperator(Stream<Videogame> stream) {
        long count = stream.count();
        System.out.println("Number of videogames: " + count);
    }
    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream) {
        boolean anyMatch = stream.anyMatch(videogame -> videogame.getTotalSold() > 1000000);
        System.out.println("Any match: " + anyMatch);
    }

    static void allMatchOperator(Stream<Videogame> stream) {
        boolean allMatch = stream.allMatch(videogame -> videogame.getTotalSold() > 1000000);
        System.out.println("All match: " + allMatch);
    }

    static void noneMatchOperator(Stream<Videogame> stream) {
        boolean allMatch = stream.noneMatch(videogame -> videogame.getReviews().isEmpty());
        System.out.println("None match: " + allMatch);
    }

    static void findFirstOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.findFirst();
        result.ifPresent(System.out::println);
    }

    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.findAny();
        result.ifPresent(System.out::println);
    }

    static void reduceOperator(Stream<Videogame> stream) {
        Optional<Integer> result = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
//        .reduce((a, b) -> a + b);

        result.ifPresent(System.out::println);
    }

    static void minOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.min((v1, v2) -> v1.getTotalSold() - v2.getTotalSold());
        result.ifPresent(System.out::println);
    }

    static void minOperator2(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.min(Comparator.comparing(Videogame::getName));
        result.ifPresent(System.out::println);
    }

    static void maxOperator(Stream<Videogame> stream) {
        Optional<Videogame> result = stream.max(Comparator.comparing(Videogame::getName));
        result.ifPresent(System.out::println);
    }
}
