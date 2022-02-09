package com.Interview;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        binarySearchOld();
        binarySearchNew();
    }

    private static void binarySearchOld() {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int searchItem = 40;

        int low = 0, high = a.length - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (searchItem == a[mid]) {
                found = mid;
                break;
            } else if (searchItem < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        if (found == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found: " + a[found] + " at element : " + found);
        }

    }

    private static void binarySearchNew() {
        // Get the Array
        int [] intArr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Arrays.sort(intArr);

        int intKey = 40;

        // Print the key and corresponding index
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, intKey));

    }
}
