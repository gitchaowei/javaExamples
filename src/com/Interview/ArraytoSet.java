package com.Interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraytoSet {
    public static void main(String[] args) {
        // instantiating an array of Strings
        String[] arrayString = new String[]{"grace", "michael", "anne"};
        // convert the Array to Set
        Set set = new HashSet<>(Arrays.asList(arrayString));
        for (Object s : set) {
            System.out.println(s);
        }
        // getting first the size of the set
        System.out.println("Initial size of set:" + set.size());
        // add a duplicate string to our set
        set.add("grace");
        System.out.println("Size of the set after adding:" + set.size());


    }

}
