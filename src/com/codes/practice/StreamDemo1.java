package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamDemo1 {
    public static void main(String[] args) {
        StreamReduce();
        StreamMapMethod();
        StreamFilter();
    }

    static void CreateStream() {
        // Create an ArrayList
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(8);
        // Convert it into a Stream
        Stream<Integer> myStream1 = myList.stream();

        // Create an array
        Integer[] myIntArray = {1, 5, 8};
        // Convert it into a Stream
        Stream<Integer> myStream2 = Arrays.stream(myIntArray);

        // Create an array
        String[] myStrArray = new String[]{"bob", "alice", "paul", "ellie"};
        // Convert it into a Stream
        Stream<String> myStream3 = Arrays.stream(myStrArray);
    }

    static void StreamMapMethod() {
        String[] myStrArray = new String[]{"bob", "alice", "paul", "ellie"};
        Stream<String> myStream = Arrays.stream(myStrArray);

        Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());
        String[] myNewArray = myNewStream.toArray(String[]::new);
        System.out.println("Map Method to Upper Cases: " + Arrays.asList(myNewArray));
    }

    //
    // A reduction operation is one which allows you to compute a result
    // using all the elements present in a stream.
    // Reduction operations are also called terminal operations because
    // they are always present at the end of a chain of Stream methods.
    // Java 8 includes several reduction methods: sum, average and count
    static void StreamReduce() {
        int myIntArray[] = { 1, 5, 8 };
        int sum = Arrays.stream(myIntArray).sum();

        System.out.println("Before reducing int array: " + myIntArray[0] + " "+ myIntArray[1]+ " "+ myIntArray[2]);
        System.out.println("After reducing int array: " + sum);

        String[] myStrArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myStrArray)
                .reduce("", (a,b) -> a + b); // cancatinate all elements into a string
        System.out.println("Before reducing: " + Arrays.asList(myStrArray));
        System.out.println("After reducing: " + result);
    }

    static void StreamFilter() {
        String[] myArray = { "this", "is", "a", "sentence" };
        String [] result = Arrays.stream(myArray).filter(s -> s.length() > 4).toArray(String[]::new);

        System.out.println("Before filtering: " + Arrays.asList(myArray));
        System.out.println("After filtering: " + Arrays.asList(result));
    }
}
