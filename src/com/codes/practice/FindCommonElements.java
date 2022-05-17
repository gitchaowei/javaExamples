package com.codes.practice;
// Java program to check if there exists a pair
// in array whose sum results in x.

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindCommonElements {
    public static void main(String[] args) {

        // Example for int[] arrays
        int A[] = {14, 0, -1, 2, -3, 1};
        int B[] = {5, -1, 2, -3, 1, 7, 12, 65};
        List <Integer> commonElements = new ArrayList<>();
        System.out.println("Array A: " + Arrays.toString(A));
        System.out.println("Array B: " + Arrays.toString(B));

//        commonElements = findCommonValues(A, B);
        findCommonValuesTest(A, B);

        }

    // Function to find and print pair
    static List findCommonValues(int A[], int[] B) {
        int size = B.length;

        // initialize
        List <Integer> commonElements = new ArrayList<>();

//        List<Integer> aList = new ArrayList<>();
//        List<Integer> bList = new ArrayList<>();

        // 1. convert int[] to List
        // Method 1:
        List<Integer> aList = IntStream.of(A).boxed().collect(Collectors.toList());
        List<Integer> bList = IntStream.of(B).boxed().collect(Collectors.toList());

//        // Method 2:
//        aList = Arrays.stream(A).boxed().collect(Collectors.toList());
//        bList = Arrays.stream(B).boxed().collect(Collectors.toList());
//        // method 3:
//        Integer[] boxedArray = Arrays.stream(A).boxed().toArray(Integer[]::new);

//        Collections.addAll(aList, boxedArray);
//        // method 4:
//        for (int i: A) {
//            aList.add(Integer.valueOf(i));
//        }
//
//        boxedArray = Arrays.stream(B).boxed().toArray(Integer[]::new);
//        Collections.addAll(bList, boxedArray);
//        // method 4:
//        for (int i: B) {
//            bList.add(Integer.valueOf(i));
//        }

        // 2. To get common elements:
        // Method 1
        for (int i = 0; i < size; i++) {
            if (aList.contains(B[i])) {
                commonElements.add(B[i]);
            }
        }

        // Method 2:
        commonElements.clear();
        commonElements.addAll(aList);
        commonElements.retainAll(bList);
        System.out.println("common values of two array: " + commonElements);

        List <Integer> aList1 = new ArrayList<> (aList);
        List <Integer> bList1 = new ArrayList<> (bList);

        aList.removeAll(commonElements);
        bList.removeAll(commonElements);

        System.out.println("Array 1 removed common values from Array 2: " + aList);
        System.out.println("Array 2 removed common values from Array 1: " + bList);

        return commonElements;
    }


    // Test other type of Arrays input
    static List findCommonValuesTest(int A[], int[] B){

        // if pass in Integer array
//        Integer[] aArr = new Integer[]{14, 0, -1, 2, -3, 1};
//        Integer[] bArr = new Integer[]{5, -1, 2, -3, 1, 7, 12, 65};
//
//        List <Integer> aList = new ArrayList(Arrays.asList(aArr));
//        List <Integer> bList = new ArrayList(Arrays.asList(bArr));

        // if pass in String array
        String[] aArr = new String[]{"A","E","X","B","C","M","W","Y"};
        String[] bArr = new String[]{"D","E","X","B","N", "P","O"};

        List <String> aList = new ArrayList(Arrays.asList(aArr));
        List <String> bList = new ArrayList(Arrays.asList(bArr));
        List<String> commonElements = new ArrayList<>(aList);

//        List<Integer> aList = IntStream.of(A).boxed().collect(Collectors.toList());
//        List<Integer> bList = IntStream.of(B).boxed().collect(Collectors.toList());

//        List<Integer> commonElements = new ArrayList<>(aList);

        commonElements.retainAll(bList);

        aList.removeAll(commonElements);
        bList.removeAll(commonElements);

        return commonElements;
    }
}
