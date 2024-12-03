package com.debuggeando_ideas.optional;

import com.debuggeando_ideas.util.Movie;

import java.util.Optional;

public class FlatMapOptional {
    public static void main(String[] args) {
        Movie movie = new Movie("The Godfather", 9.5);
        Optional<Movie> optionalMovie = Optional.of(movie);

        String movieName = optionalMovie.flatMap(Movie::getName)
                .orElseThrow(RuntimeException::new);

        System.out.println(movieName);
    }
}
