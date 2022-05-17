package com.codes.practice;
// Java implementation using Hashing

import java.util.*;

class NumberPairSum1 {
    // Driver Code
    public static void main(String[] args) {
        // assume the integer array has no duplicated numbers
        int dupA[] = {1, 6, 4, 45, 6, 10, 8,10, 12};
        //int [] ret;   // used for only one pair returned
        Map <Integer, List> pairsRet1;
        Map <Integer, Integer> pairsRet2;

        int sum = 16;

        System.out.println("input array: " + Arrays.toString(dupA));

        pairsRet1 = findPairs_BruteForce(dupA, sum);

        System.out.printf("Pairs of indexes for the Sum % d from findPairs_BruteForce(A, sum): \n" , sum);
        for (Map.Entry entry: pairsRet1.entrySet() ) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        int nodupA[] = {1, 6, 4, 45, 8,10, 12};

        pairsRet2 = FindPairs_HashMap_NoDup(nodupA, sum);
        System.out.printf("Pairs of indexes for the Sum % d from FindPairs_HashMap(A, sum): \n" , sum);
        for (Map.Entry entry: pairsRet2.entrySet() ) {
            System.out.println(entry.getKey()+" " + entry.getValue());
        }

        pairsRet2 = SortArrayApproach_NoDup(nodupA, sum);
        System.out.printf("Pairs of indexes for the Sum % d from SortArrayApproach(A, sum): \n" , sum);
        for (Map.Entry entry: pairsRet2.entrySet() ) {
            System.out.println(entry.getKey()+" " + entry.getValue());
        }
    }

    // Given an array of integers, return the indices of the two numbers whose sum is equal to a given target.
    //
    // The naive approach is to just use two nested for loops and check if the sum of any two elements
    // in the array is equal to the given target.
    // *** Consider multiple matching from the array
    // *** Case 1) if multiple matches from a array with element duplication
    // ***         then, a map with <Integer, ArrayList> map returned
    // *** Case 2) if multiple matches from a array with no element duplication
    //            then, a map with <Integer, Integer> map returned
    // Time complexity: O(n^2)
    private static Map <Integer, List> findPairs_BruteForce(int[] nums, int target) {
    // if the array has no element duplication, int [i,j] returned
    //private static int[] findTwoSum_BruteForce(int[] nums, int target) {

        Map <Integer, List> pairsMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            // ArrayList is used for storing matched (duplicated) elements
            List<Integer> indexj = new ArrayList();
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {

                    // if input array has element duplication
                    // then put all matched pairs into a map for each i
                    indexj.add(j);

                    // if input array has no element duplication
                    //pairsMap.put(i,j);
                    //
                    // if only one pair for the sum, just return an array of int []
                    //return new int[] { i, j };
                }
            }
            if (indexj.size() > 0) {
                pairsMap.put(i,indexj);
            }
        }
        return pairsMap;

        // if no pair exists for the sum, just return an empty int []
        //return new int[] {};
    }

    // Assume the input array has no element duplication.
    // Possible multiple pairs returned by using HashMap
    // Use HashMap (does not allow Key duplication)
    static Map <Integer, Integer>  FindPairs_HashMap_NoDup(int arr[], int sum) {
        // HashSet does not allow duplication
        // Using s.contains(temp) to check the existing number
        // ** only one pair of values can be returned if use HashSet
       // HashSet<Integer> s = new HashSet<Integer>();

        Map <Integer, Integer> numIndexMap = new HashMap();
        Map <Integer, Integer> retIndexMap = new HashMap();

        for (int i = 0; i < arr.length; ++i) {
            // arr[i]'s complement value
            int temp = sum - arr[i];

            // checking if the complement value exists in the HashSet already
            if (numIndexMap.containsKey(temp)) {

                int index = numIndexMap.get(temp);
                retIndexMap.put(i, index);  // no duplication of i since no element duplication
//                System.out.println("Pair with given sum "
//                        + sum + " is (" + arr[i] + " " + arr[index]+ ")");
//                System.out.println("Pair (index) with given sum "
//                        + sum + " is (" + i + " " + index + ")");
            }
            numIndexMap.put(arr[i], i);
        }
        return retIndexMap;
    }

    // Function to check if array has 2 elements
    // whose sum is equal to the given value
    // Assume possible multiple pairs found: using HashMap to save pairs for return
    static Map <Integer, Integer>   SortArrayApproach_NoDup(int A[], int sum) {
        int l, r;
        Map <Integer, Integer> retIndexMap = new HashMap();

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = A.length - 1;
        while (l < r) {
            if (A[l] + A[r] == sum) {
                retIndexMap.put(l,r);
                r--;
                l++;
 //               System.out.println("The pair is : (" + A[l] + ", " + A[r] + ")");
            }
            else if (A[l] + A[r] < sum) {
                l++;
            }
            else { // A[i] + A[j] > sum
                r--;
            }
        }
        return retIndexMap;
    }
}

