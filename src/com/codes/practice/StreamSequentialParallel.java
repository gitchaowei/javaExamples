package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
//
// A stream in Java is a sequence of objects which operates on a data source such as an array or a collection and supports various methods.
// It was introduced in Java 8’s java.util.stream package.
// Stream supports many aggregate operations like filter, map, limit, reduce, find, and match to customize the original data into
// a different form according to the need of the programmer.
// The operations performed on a stream do not modify its source hence a new stream is created according to the operation applied to it.
// The new data is a transformed copy of the original form.
//
// Sequential Streams are non-parallel streams that use a single thread to process the pipelining.
// Any stream operation without explicitly specified as parallel is treated as a sequential stream.
// Sequential stream performs operation one by one.
//
// Parallel stream leverage multi-core processors, which increases its performance.
//
// The Java stream library provides a couple of ways to do it. easily, and in a reliable manner.
//
// 1) One of the simple ways to obtain a parallel stream is by invoking the parallelStream() method of Collection interface.
// 2) Another way is to invoke the parallel() method of BaseStream interface on a sequential stream.
//
public class StreamSequentialParallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SeqStream();
    }

    static void SeqStream() throws ExecutionException, InterruptedException {
        List<Integer> listOfNumbers1 = Arrays.asList(14, 24, 34, 44);
        listOfNumbers1.stream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        // output:
        // 14 main
        // 24 main
        // 34 main
        // 44 main
        List<Integer> listOfNumbers2 = Arrays.asList(15, 25, 35, 45);

        // invoking the parallelStream() method of Collection interface,
        listOfNumbers2.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );
        // output:
        // 35 main
        // 15 ForkJoinPool.commonPool-worker-7
        // 45 ForkJoinPool.commonPool-worker-5
        // 25 ForkJoinPool.commonPool-worker-3

        List<Integer> listOfNumbers3 = Arrays.asList(1, 2, 3, 4);
        int sum = listOfNumbers3.parallelStream().reduce(5, Integer::sum);  // Integer.sum(int a, int b)
        System.out.println("sum from inside adding is: " + sum);
        // Output is 30
        // above actual result might differ depending on the number of threads used
        // in the common fork-join pool
        // In order to fix this issue, the number five should be added outside of the parallel stream:
        sum = listOfNumbers3.parallelStream().reduce(0, Integer::sum) + 5;
        System.out.println("sum from outside adding is: " + sum);
        // Output is 15
        //
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        sum = customThreadPool.submit(
                () -> listOfNumbers3.parallelStream().reduce(0, Integer::sum)).get();
        customThreadPool.shutdown();
        System.out.println("sum with ForkJoinPool 4 is: " + sum);

        // Here parallel has the worse performance because
        // sometimes the overhead of managing threads, sources and results is
        // a more expensive operation than doing the actual work.
        sum = IntStream.rangeClosed(1, 100).reduce(0, Integer::sum);
        System.out.println("sum from IntStream sequential is: " + sum);

        // invoke the parallel() method of BaseStream interface on a sequential stream.
        sum = IntStream.rangeClosed(1, 100).parallel().reduce(0, Integer::sum);
        System.out.println("sum from IntStream parallel is: " + sum);

        // try another example for performance
        // converting a sequential stream into a parallel one brings performance benefits only for an ArrayList
        // not for linkedList
        List<Integer> arrayListOfNumbers = new ArrayList<>();
        List<Integer> linkedListOfNumbers = new LinkedList<>();
        IntStream.rangeClosed(1, 1_000_000).forEach(i -> {
                arrayListOfNumbers.add(i);
                linkedListOfNumbers.add(i);
        });
        arrayListOfNumbers.stream().reduce(0, Integer::sum);
        arrayListOfNumbers.parallelStream().reduce(0, Integer::sum);
        linkedListOfNumbers.stream().reduce(0, Integer::sum);
        linkedListOfNumbers.parallelStream().reduce(0, Integer::sum);
    }

}
