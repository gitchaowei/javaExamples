package com.codes.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortInsertionSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10);
        }

        System.out.println("Before:");
        printArray(numbers);

        insertSort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void insertSort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            // save current position value
            int currentValue = inputArray[i];

            int j = i - 1;
            while (j >= 0 && inputArray[j] > currentValue) {
                inputArray[j + 1] = inputArray[j]; //shift
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }


    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
