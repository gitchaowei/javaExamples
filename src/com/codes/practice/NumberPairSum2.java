package com.codes.practice;

import java.util.*;

public class NumberPairSum2 {
    public static void main(String[] args) {
        int[] arr={3, 5,4,5,6,7,8,9};  //initializing array
        int sum = 12;
        Map<Integer,Integer> pairs;
        // return duplicated pairs
        pairs = returnHashMapIndexPairs(arr, sum);
        System.out.println("integer array is:" + Arrays.toString(arr));
        System.out.println("Index Pairs for sum of 12 (keep duplication):" +pairs);

        // return pairs without duplication
        pairs = returnHashMapValuePairs(arr, sum);
        System.out.println("integer array is:" + Arrays.toString(arr));
        System.out.println("Element value Pairs for sum of 12 (without duplication):" +pairs);

        int arr1[] = {0, 1, 5, 7, 5, -1,1, 5,1 };
        sum=6;
        // return count of duplication
        pairs= printPairsCount(arr1,sum);
        System.out.println("Element value duplication: " +pairs);
    }

    // Input array allows element duplication
    // Return index pairs for meeting sum
    //
    // Naive method:
    public static Map<Integer,Integer> returnHashMapIndexPairs(int[] arr, int sum)
    {
        // assume arr array allows duplicated values
        // then use HashMap to save index pairs
        //
        Map <Integer,Integer> pairMap = new HashMap();

        for (int i=0; i< arr.length; i++) {
            for (int j=i+1; j< arr.length; j++) {

                if (arr[i] + arr[j] == sum) {
                    pairMap.put(i,j);
                }
            }
        }
        return pairMap;
    }

    // 1. Print number of pairs in arr[0..n-1] with sum equal to 'sum'
    // 2. return <value, count> Map
    public static Map printPairsCount(int arr[], int sum)
    {

        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for(int i = 0; i < arr.length; i++)
        {
            // Search if a pair can be formed with
            // arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);
                // print number of pairs for arr[i]
                for (int j = 0; j < count; j++) {
                    System.out.print("(" + rem + ", " + arr[i] + ")" + "\n");
                }
            }
            // update arr[i] count in the map
            if (mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else
            {
                mp.put(arr[i], 1);
            }
        }
        return mp;
    }

    // Restriction: Input array has no element duplication
    // Return array element value pairs for meeting sum
    public static Map<Integer,Integer> returnHashMapValuePairs(int[] arr, int sum)
    {
        // assume arr array has no duplicated values
        // then using HashMap and HashSet to save values
        //
        // HashSet does not allow duplication
        // Using s.contains(temp) to check the existing number
        //
        Map <Integer,Integer> pairMap = new HashMap();
        Set <Integer> arrSet = new HashSet();

        for (int i=0; i< arr.length; i++) {
            int temp = sum-arr[i];
            if (arrSet.contains(temp)) {
                // exists
                pairMap.put(temp,arr[i]);
            }
            arrSet.add(arr[i]);
        }
        return pairMap;
    }
}

