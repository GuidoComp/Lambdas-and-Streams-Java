package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        join(videogames);
    }

    static void avg(Stream<Videogame> stream) {
        Double avg = stream
                .collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println("Average price: " + avg);
    }

    static void sum(Stream<Videogame> stream) {
        IntSummaryStatistics sum = stream
                .collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        System.out.println("Total reviews: " + sum.getSum());
        System.out.println("Average reviews: " + sum.getAverage());
        System.out.println("Max reviews: " + sum.getMax());
        System.out.println("Min reviews: " + sum.getMin());
    }

    static void join(Stream<Videogame> stream) {
        String join = stream
                .map(Videogame::toString)
                .collect(Collectors.joining("\n"));
        System.out.println("Join: " + join);

    }
}
