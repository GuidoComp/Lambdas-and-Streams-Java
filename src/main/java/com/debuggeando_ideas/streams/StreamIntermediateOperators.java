package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        dropWhileOperator(videogames);
    }

    static void distinctOperator(Stream<Videogame> stream) {
        System.out.println(stream.distinct().count());
    }

    static void limitOperator(Stream<Videogame> stream) {
        List<Videogame> limitedVideogames = stream.limit(5).collect(Collectors.toList());
        limitedVideogames.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> stream) {
        List<Videogame> limitedVideogames = stream.skip(15).collect(Collectors.toList());
        limitedVideogames.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> filteredVideogames = stream
                .filter(v -> v.getPrice() > 12.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());

        filteredVideogames.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole())
                            .build();
                })
                .collect(Collectors.toList());
        basicVideogames.forEach(System.out::println);
        System.out.println("-----");
        List<String> titles = basicVideogames.stream()
                .map(BasicVideogame::getName)
                .collect(Collectors.toList());
        titles.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> stream) {
        List<Review> result = stream
                .flatMap(v -> v.getReviews().stream())
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void mapVSFlatMap(Stream<Videogame> stream) {
//        var totalReviews = stream
//                .map(v -> v.getReviews().size())
//                .collect(Collectors.toList());
//        Long totalReviews = stream
//                .mapToLong(v -> v.getReviews().size()).sum();
        Long totalReviews = stream
                .flatMap(v -> v.getReviews().stream())
                .count();
        System.out.println(totalReviews);
    }

    static void peekOperator(Stream<Videogame> stream) {
//        stream.peek(System.out::println).collect(Collectors.toList());
        stream.peek(v -> v.setName("")).forEach(System.out::println);
    }

    static void sortOperator(Stream<Videogame> stream) {
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());
        listSorted.forEach(System.out::println);
    }

    static void takeWhileOperator(Stream<Videogame> stream) {
        List<Videogame> result = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream) {
        List<Videogame> result = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
