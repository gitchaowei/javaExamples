package com.codes.practice;

import java.util.*;

// Comparison: HashSetLinkedHashSetTreeSet
public class CollectionSetComparison {
    public static void main(String args[]) {
        insertionOrder();
        insertionTime();
        deletionTime();
    }

    // Function show insertion order of
    // LinkedHashSet, TreeSet and HashSet
    private static void insertionOrder() {
        LinkedHashSet<String> geekLinkSet = new LinkedHashSet<>(); // insertion order
        TreeSet<String> geekTreeSet = new TreeSet<>();  // sorted
        HashSet<String> geekHashSet = new HashSet<String>(); // order is random, not constant during insertion time.

        List <String> list = Arrays.asList("Geek2", "Geek1", "Geek3", "Geek1");
        System.out.println("Original array:" + list);

        // Add three object in LinkedHashSet, TreeSet, and HashSet
        for (String str : list) {

            geekLinkSet.add(str);
            geekTreeSet.add(str);
            geekHashSet.add(str);
        }

        // HashSet does not guarantee the constant order of elements over time
        System.out.println("Order of objects in HashSet:" + geekHashSet);

        // insertion order or elements LinkedHashSet
        // stored elements as insertion
        System.out.println("Order of objects in LinkedHashSet :" + geekLinkSet);

        // should be sorted order TreeSet
        // stores element in sorted order
        System.out.println("Order of objects in TreeSet :" + geekTreeSet);
    }

    //
    // Calculate insertion time of 1000 objects of LinkedHashSet, TreeSet and HashSet
    // Output shows: HashSet insertion is fastest and TreeSet insertion is slowest.
    //
    private static void insertionTime() {
        // HashSet performance Test
        // inserting 1000 elements
        HashSet<Integer> numbersHS = new HashSet<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numbersHS.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Total time to insert"
                + " 1000 elements in"
                + " HashSet in nanoseconds: "
                + (endTime - startTime));

        // LinkedHashSet performance Test
        // inserting 1000 elements
        LinkedHashSet<Integer> numbersLLS = new LinkedHashSet<>();

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numbersLLS.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Total time to insert"
                + " 1000 elements in"
                + " LinkedHashSet nanoseconds: "
                + (endTime - startTime));

        // TreeSet performance Test inserting 1000 objects
        TreeSet<Integer> numbersTS = new TreeSet<>();

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numbersTS.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Total time to insert"
                + " 1000 elements in"
                + " TreeSet in nanoseconds: "
                + (endTime - startTime));
    }

    // Calculate deletion time of 1000 objects LinkedHashSet, TreeSet and HashSet
    // Output shows: HashSet deletion is fastest and TreeSet insertion is slowest.
    // Deletion time always vary
    private static void deletionTime() {
        // HashSet performance Test inserting
        // and deletion 1000 elements
        HashSet<Integer> deletionHS = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            deletionHS.add(i);
        }

        long startingTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            deletionHS.remove(i);
        }

        long endedTime = System.nanoTime();
        System.out.println(
                "Total time to Deletion "
                        + "1000 elements in HashSet in nanoseconds: "
                        + Math.abs(startingTime - endedTime));

        // LinkedHashSet  performance Test inserting
        // and deletion 1000 elements
        LinkedHashSet<Integer> deletionLLS
                = new LinkedHashSet<>();

        for (int i = 0; i < 1000; i++) {
            deletionLLS.add(i);
        }
        startingTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            deletionLLS.remove(i);
        }

        endedTime = System.nanoTime();
        System.out.println(
                "Total time to Deletion 1000"
                        + " elements in LinkedHashSet in nanoseconds: "
                        + Math.abs(startingTime - endedTime));

        // TreeSet performance Test inserting
        // and deletion 1000 elements
        TreeSet<Integer> deletionTS = new TreeSet<>();

        for (int i = 0; i < 1000; i++) {
            deletionTS.add(i);
        }

        startingTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            deletionTS.remove(i);
        }

        endedTime = System.nanoTime();
        System.out.println(
                "Total time to Deletion 1000"
                        + " elements in TreeSet in nanoseconds: "
                        + Math.abs(startingTime - endedTime));
    }
}
