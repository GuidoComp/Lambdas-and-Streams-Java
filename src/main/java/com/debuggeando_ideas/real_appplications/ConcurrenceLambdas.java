package com.debuggeando_ideas.real_appplications;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ConcurrenceLambdas {
    static Runnable printerSum = () -> {
        Long numero = 0L;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            numero += i;
        }
        System.out.println(numero);
    };

    static Callable<Long> getSum = () -> {
        Long numero = 0L;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            numero += i;
        }
        return numero;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        printerSum.run();
        var exec = Executors.newSingleThreadExecutor();
        exec.submit(printerSum);

        var result = exec.submit(getSum);
        System.out.println("Result: " + result.get());
        exec.shutdown();
    }
}
