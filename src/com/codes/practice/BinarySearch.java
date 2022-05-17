package com.codes.practice;

import java.util.Arrays;

// Given a sorted array arr[] of n elements, write a function to search a given element x in arr[]
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};  // sorted array
        int index;
        int x= 40;

        index = binarySearchOld1(a, x);
        System.out.println(x + " found at index = " + index);

        index = binarySearchOld2(a, 0, a.length-1, x);
        System.out.println(x + " found at index = " + index);

        index = binarySearchNew(a, x);
        System.out.println(x + " found at index = " + index);
    }

    // return index found or -1 not found
    //
    private static int binarySearchOld1(int[] arr, int x) {

        int low = 0, high = arr.length - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == arr[mid]) {
                found = mid;
                break;
            }
            else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return found;
    }

    // recursive calls used
    //
    // return index found or -1 not found
    private static int binarySearchOld2(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchOld2(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchOld2(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }


    private static int binarySearchNew(int[] arr, int x) {
        // sort it if it is not sorted
        Arrays.sort(arr);

        int index = Arrays.binarySearch(arr, x);
        return index;
    }
}
