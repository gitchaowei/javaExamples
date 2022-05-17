package com.codes.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// use Collections.sort(list); sort a list only
public class SortCollectionSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10);
        }
        CollectionsSort(numbers);

        printArray(numbers);
    }

    private static void CollectionsSort(int[] intArray) {
        // method 1: work on inputArray directly
        //Arrays.sort(inputArray);

        // method 2:
        // convert to Integer list
        //
        List<Integer> intList = new ArrayList<>(intArray.length);
        for (int i: intArray) {
            intList.add(Integer.valueOf(i));
        }
        // or
        //intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        // or
        //intList = IntStream.of(intArray).boxed().collect(Collectors.toList());

        Collections.sort(intList);
        System.out.println("Sorted integer array: " + intList);

    }
    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
