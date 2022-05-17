package com.codes.practice;

import java.util.Random;

public class SortBubbleSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println("Before:");
        printArray(numbers);

        //Sorting algorithm here
        boolean swappedSomething = true;
        int j = numbers.length - 1;
        while (swappedSomething) {
            swappedSomething = false;
            // bubble the larger number from left to right
            // and then to the end of the loop numbers[j]
            for (int i = 0; i < j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swappedSomething = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
            j--;
            if (j == 0) break;
        }
        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
