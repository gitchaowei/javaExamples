package com.codes.practice;

import java.util.Random;

public class SortMergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[11];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

//        mergeSort(numbers);
        mergeSortTest(numbers);
        System.out.println("\nAfter:");
        printArray(numbers);
    }


    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        // create left half
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        // create right half
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
        return;
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        // merge smaller value into inputArray
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        // till this step, either left or right half is completed.
        // then check un-completed half for merging
        //
        // merge the rest of left half
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        // merge the rest of right half
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void mergeSortTest(int[] inputArr) {
        int length = inputArr.length;

        if (length <2)
            return;

        int mid = length/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length-mid];

        int count=0;
        for (int i = 0; i<mid; i++) {
            leftArr[i] = inputArr[i];
            rightArr[i] = inputArr[mid+i];
            count++;
            count++;
        }
        if (length != count)
            rightArr[mid] = inputArr[length-1];

        mergeSortTest(leftArr);
        mergeSortTest(rightArr);

        mergeArray(inputArr, leftArr, rightArr);

        return;
    }

    // left side and right side arrays are sorted already
    // merge sort into inputArr for return
    public static void mergeArray(int[] inputArr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                inputArr[k] = leftArr[i];
                i++;
            } else {
                inputArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArr.length) {
            inputArr[k] = leftArr[i];
            i++;
            k++;
        }
        while ( j < rightArr.length) {
            inputArr[k] = rightArr[j];
            j++;
            k++;
        }
    }



    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
