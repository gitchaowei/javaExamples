package com.Interview;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumbers {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 2, 5, 4, 5};

        Set<Integer> hs = new HashSet<Integer>();
        for (int elem : a) {
            if (hs.add(elem) == false) {
                System.out.println(elem);
            }

            //System.out.println(elem + "--> " + hs.add(elem)); //add false means duplication
        }
    }
}
