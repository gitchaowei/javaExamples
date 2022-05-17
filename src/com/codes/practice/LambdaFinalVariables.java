package com.codes.practice;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

// Test Capturing Lambdas for local variable
// lambda expressions can only use final or effectively final local variables
// using int[] array means holder reference variable is ?
public class LambdaFinalVariables {
    public static void main(String[] args) {

        System.out.println(workaroundLambdaSingleThread());

        workaroundMultithreading();
        workaroundMultithreading();

        workaroundMultithreadingFinal();
    }

    // test final and effectively final variable used in lambda function
    // workaroundSingleThread()
    private static int workaroundLambdaSingleThread() {
        int[] holder = new int[] { 2 };

        IntStream sums = IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0]);

        holder[0] = 0;

        // can not use sums twice:
//        OptionalDouble ave = sums.average();
//        Double d= ave.getAsDouble();
//        System.out.println("average: " + d);

        int sum = sums.sum(); // Lambdas executes after hold[0] =0. return 6 not 12

        return sum;
    }

    // If it's short enough to let the execution of the method terminate
    // before the other thread is executed it'll print 6, otherwise, it'll print 12.
    private static void workaroundMultithreading() {
        int[] holder = new int[] { 2 };
        Runnable runnable = () -> System.out.println(IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0])
                .sum());

        new Thread(runnable).start();

        // simulating some processing
        try {
            Thread.sleep(new Random().nextInt(3) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        holder[0] = 0;
    }

    private static void workaroundMultithreadingFinal() {
        final int holder = 2;  // final
        // or without final as following,
        // but effectively final if the value is not changed in this method
        //int holder = 2;

        Runnable runnable = () -> System.out.println(IntStream
                .of(1, 2, 3)
                .map(val -> val + holder)
                .sum());

        new Thread(runnable).start();

        // simulating some processing
        try {
            Thread.sleep(new Random().nextInt(3) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
