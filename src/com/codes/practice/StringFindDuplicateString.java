package com.codes.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringFindDuplicateString {

    public static void main(String[] args) {
        //method1();
//        method2();
//        method3();
        method4();
        method5();
        method6();

    }

    // Brute Force Method (two for loop)
    public static void method1() {
        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java"};
        // first solution: finding duplicates using brute force method
        System.out.println("finding duplicate elements in array using brute force method");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("    Duplicate elements at indexes: " + i + " and " + j + " " + names[i]);
                }
            }
        }
    }
    // Second solution 8 use HashSet data structure to find duplicates
    public static void method2() {
        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java"};
        System.out.println("Duplicate elements from array using HashSet.add() for return false");
        Set<String> store = new HashSet<>();
        for (String name : names) {
            if (store.contains(name)) {
                System.out.println("    Found a duplicate element in array : " + name);
            }
            store.add(name);
        }
    }
    // Third solution: using Hash table data structure to find duplicates
    public static void method3() {
        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java"};
        System.out.println("Duplicate elements from array using HashMap.get(name) return count");
        Map<String, Integer> nameCountMap = new HashMap<>();
        // build hash table with count
        for (String name : names) {
            Integer count = nameCountMap.get(name);
            if (count == null) {
                nameCountMap.put(name, 1);
            } else {
                nameCountMap.put(name, ++count);
            }
        }
        // print duplicate elements from the Hash Table
        Set<Map.Entry<String, Integer>> entrySet = nameCountMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            int count = entry.getValue();
            if (entry.getValue() > 1) {
                System.out.println("    Duplicate element is: " + entry.getKey() + " count: " + count);
            }
        }
    }

    // 1. Given a list of strings or chars
    // 2. create a HashSet of the list (unique values only)
    // 3. Iterate the HashSet and use Collections.frequency(list, s) to get count
    private static void method4() {

        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java", "C++", "C"};
        List<String> list = Arrays.asList(names);
        System.out.println("Method 4 use Collections.frequency(list, s):");

        HashMap <String, Integer> countMap = new HashMap();

        Set<String> distinct = new HashSet<>(list);
        for (String s: distinct) {
            int count = Collections.frequency(list, s);
            System.out.println(s + ": " + count);
            // can be saved into HashMap
            countMap.put(s, count);
        }
    }

    // use stream
    private static void method5() {

        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java", "C++", "C"};

        List<String> list = Arrays.asList(names);

        System.out.println("Method 5 use char list.stream():");
        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        for (Map.Entry<String, Long> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Use HashMap.merge()
    private static void method6() {

        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java", "C++", "C"};
        List<String> list = Arrays.asList(names);

        System.out.println("Method 6 use HashMap.merge():");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : list) {
            frequencyMap.merge(s, 1, Integer::sum); // also see CollectionHashMap.java file
        }
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
