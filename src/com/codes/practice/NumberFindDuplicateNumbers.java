package com.codes.practice;

import java.util.HashSet;
import java.util.Set;

// use HashSet
public class NumberFindDuplicateNumbers {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 2, 5, 4, 5};
        //
        // HashSet can have a single null value.
        // hs.add(elem) returns false if value exists
        //
        Set<Integer> hs = new HashSet<Integer>();
        for (int elem : a) {
            if (hs.add(elem) == false) {
                System.out.println(elem);
            }

            //System.out.println(elem + "--> " + hs.add(elem)); //add false means duplication
        }
    }
}
