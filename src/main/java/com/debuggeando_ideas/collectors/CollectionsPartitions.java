package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsPartitions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        Map<Boolean, List<Videogame>> result = videogames.collect(Collectors.partitioningBy(v -> v.getPrice() > 15.0));
        result.forEach((k, v) -> System.out.println(k + " - " + v));
//        result.get(true).stream().sorted(Comparator.comparing(Videogame::getPrice)).forEach(System.out::println); ordeno la lista de los que cuestan más de 15 por precio.
    }
}
