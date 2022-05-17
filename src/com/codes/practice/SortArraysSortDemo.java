package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArraysSortDemo {

    public static void main(String args[]){
        ArraysSort();
        ArraysSortSubarray();
    }


    private static void ArraysSort() {
        int[] intArr = { 13, 7, 6, 45, 21, 9, 101, 102 };
        String [] strArr = {"Geeks For Geeks","Friends","Dear","Is","Superb"};

        // Calling the Arrays.sort() method works for array of primitive type or reference type
        // inside Arrays class
        Arrays.sort(intArr);
        Arrays.sort(strArr);

        // Printing and display sorted array
        System.out.printf("Sorted int array [] : %s\n", Arrays.toString(intArr));
        System.out.printf("Sorted String array[] : %s\n", Arrays.toString(strArr));

        // Note that Integer here instead of
        // int[] as Collections.reverseOrder doesn't
        // work for primitive types.
        Integer[] IntArr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        String [] strArr1 = {"Geeks For Geeks","Friends","Dear","Is","Superb"};

        // Sorts arr[] in descending order
        Arrays.sort(IntArr, Collections.reverseOrder());
        Arrays.sort(strArr1, Collections.reverseOrder());

        System.out.printf("Sorted Integer array [] reversely (Collections.reverseOrder()): %s\n", Arrays.toString(IntArr));
        System.out.printf("Sorted Integer array [] reversely (Collections.reverseOrder()): %s\n",  Arrays.toString(strArr1));
    }
    private static void ArraysSortSubarray() {
// Custom input array
        int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };

        // Sort subarray from index 1 to 4, i.e.,
        // only sort subarray {7, 6, 45, 21} and
        // keep other elements as it is.
        Arrays.sort(arr, 1, 5);

        // Printing sorted array
        System.out.printf("Subarray sorted: %s", Arrays.toString(arr));
    }

}
