package com.debuggeando_ideas.fundamentals;

import com.debuggeando_ideas.lambdas.Math;

import java.util.List;
import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        // Instancia anónima de la interfaz funcional.
        DatabaseService<String> databaseService = new DatabaseService<String>(){

            @Override
            public String getById(Long id) {
                return "";
            }

            @Override
            public List<String> getAllRecords() {
                return List.of();
            }
        };

        // Instanciamos otra interfaz funcional.
        Function<String,String> function = new Function<String,String>(){

            @Override
            public String apply(String t) {
                return t;
            }
        };

        Math sum = new Math() {
            @Override
            public Double excecute(Double a, Double b) {
                return a + b;
            }
        };
        System.out.println(sum.excecute(2.0, 3.0));

        // Lambda: simplificación de la clase anónima.
        Math substract = (a, b) -> {
            System.out.println("Substracting " + a + " - " + b);
            return a - b;
        };
        System.out.println(substract.excecute(2.0, 3.0));
    }

}
