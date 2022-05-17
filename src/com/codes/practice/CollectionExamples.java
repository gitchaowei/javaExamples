package com.codes.practice;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionExamples {
    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) {

        int[] intA1 = new int[]{1, 3, 5, 6};
        int[] intA2 = {4, 56, 23, 87, 11, 32};
        for (int i = 0; i < intA1.length; i++) {
            System.out.println(intA1[i]);
        }
        System.out.println("Another Array:");
        for (int i = 0; i < intA2.length; i++) {
            System.out.println(intA2[i]);
        }
        // string array to a list
        String[] strA2 = {"4", "56", "23", "87", "11", "32"};
        List<String> strList = Arrays.asList(strA2);
        for (String s : strList) {
            System.out.print(s + " ");
        }
        System.out.println("Collections printout List " + strList);
        System.out.println();

        // int array to a list - method 1
        List<Integer> intList1 = new ArrayList<>(intA2.length);
        for (int i : intA2) {
            intList1.add(Integer.valueOf(i));
        }
        System.out.println("int array to List 1: " + intList1);
        // then use Collections.sort(List) to sort
        Collections.sort(intList1);
        System.out.println("int array to List 1 (sorted): " + intList1);

        // int array to a list - method 2
        List<Integer> intList2 = Arrays.stream(intA2)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
        System.out.println("int array to List 2: " + intList2);
        // then use Collections.sort(List) to sort
        Collections.sort(intList2);
        System.out.println("int array to List 2 (sorted): " + intList2);

        //1. HarshSet sequence is in hash values not add sequence
        //2. no duplicate value allowed
        Set<Integer> intSet = new HashSet<>();
        intSet.add(34);
        intSet.add(6);
        intSet.add(23);
        intSet.add(2);
        intSet.add(6); // return false for adding a duplicated value
        intSet.remove(6);
        for (Integer i : intSet) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Not sorted HashSet after remove: " + intSet);


        // Sorting HashSet using List
        List<Integer> list = new ArrayList<>(intSet);
        Collections.sort(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Sorted HashSet (sorted by Collections.sort(list): " + list);

        //1. TreeSet sequence is in sorted order
        //2. no duplicate value is allowed
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(10);
        ts.add(61);
        ts.add(87);
        ts.add(39);
        ts.add(61);  // return false for adding a duplicated value
        // Display message for better readability
        System.out.println("TreeSet: " + ts);

        // Looping over the TreeSet values
        for (Integer value : ts) {
            System.out.print(value + ", ");
        }
        System.out.println();

        //1. HashMap sequence is in hash values not add sequence
        //2. no duplicate key is allowed. Overwrite existing key with the new value
        Map<Integer, String> testHarshMap = new HashMap<Integer, String>();
        testHarshMap.put(34, "Adam");
        testHarshMap.put(6, "John");
        testHarshMap.put(23, "Mary");
        testHarshMap.put(2, "Smith");
        testHarshMap.put(6, "John Smith");
        System.out.println("Not sorted HashMap: " + testHarshMap);

        //1. TreeMap sequence is in sorted order
        //2. no duplicate value is allowed. overwrite existing key with the new value
        Map<Integer, String> testTreeMap = new TreeMap<Integer, String>();
        testTreeMap.put(34, "Adam");
        testTreeMap.put(6, "John");
        testTreeMap.put(23, "Mary");
        testTreeMap.put(2, "Smith");
        testTreeMap.put(6, "John Smith");
        System.out.println(testTreeMap);


        //Iterator
        Iterator<Integer> its = ts.iterator(); // from TreeSet
        while (its.hasNext()) {
            System.out.println("Iterator (TreeSet) has next():" + its.next());
        }

        Iterator<Integer> ints = intSet.iterator(); // from HarshSet
        while (ints.hasNext()) {
            System.out.println("Iterator (HashSet) has next():" + ints.next());
        }

        Iterator<Integer> intlist = list.iterator(); // from ArrayList
        while (intlist.hasNext()) {
            System.out.println("Iterator (ArrayList) has next():" + intlist.next());
        }
    }
}
