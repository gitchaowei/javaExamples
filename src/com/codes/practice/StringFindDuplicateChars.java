package com.codes.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringFindDuplicateChars {
    public static void main(String[] args) {

        String str = "GreaT Responsibility";
//        method1(str); // use char list
//        method2(str); // use char array
//        method3(str); // use HashMap to save char-count pairs
        method4();
        method5();
        method6();
    }

    // 1. create a list
    // 2. loop string chars
    // 3. check in list.contains() and add char into the list
    // 4. count
    private static void method1(String str) {

        // remove spaces
        String s1 = str.replaceAll("\\s", "");
        //Converts given string into character array
        String strLowerCase = s1.toLowerCase();

        int count = 1;
        System.out.println("Method 1 Character and count:");

        List<Character> charList = new ArrayList<>();
        for (int i=0; i< strLowerCase.length(); i++) {
            char ch = strLowerCase.charAt(i);
            if (!charList.contains(ch)) {
                for (int j= i+1; j<strLowerCase.length();j++){
                    if (ch==strLowerCase.charAt(j)) {
                        count++;
                    }
                }
            }
            if (count >1) {
                System.out.println(ch + ": count: "+ count);
            }

            charList.add(ch);
            count = 1;
        }

    }


    // 1. Use two for loops of char array created
    // 2. set charArray[j] = '0' after counted when loop i
    // 3. print count in i loop if charArray[i] != '0'
    private static void method2(String str) {

        int count;

        // remove spaces
        String s1 = str.replaceAll("\\s", "");
        //Converts given string into character array
        char[] charArray = s1.toLowerCase().toCharArray();

        System.out.println("Method 2 Character and count:");
        //Counts each character present in the string
        for (int i = 0; i < charArray.length; i++) {
            count = 1;
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    charArray[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if (count > 1 && charArray[i] != '0')
                System.out.println(charArray[i] + ": Count: " + count);
        }
    }

    // method 3: HashMap saves count
    // 1. HashMap stores key-value pairs and it does not allow duplicate keys.
    //    It allows one null for key and multiple null for values
    // 2. loop char array from the String.charAt(i)
    // 3. HashMap.contains(char)  or use HashMap.get(ch) for count:
    //      if true, then update count by +1,
    //      if false, .put(char, 1) initial count 1 for current char
    // 4. HashMap will be used for printing or return
    private static void method3(String str) {

        // remove spaces
        String s1 = str.replaceAll("\\s", "");
        //Converts given string into character array
        String strLowerCase = s1.toLowerCase();

        System.out.println("Method 3 Character and count:");

        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < strLowerCase.length(); i++) {
            char ch = strLowerCase.charAt(i);
            Integer count = results.get(ch);
            if (count == null)
                count=0;
            results.put(ch, count+1);
            // or
//            if (results.containsKey(ch)) {
//                results.put(ch, results.get(ch) + 1);
//            } else {
//                results.put(ch, 1);
//            }
        }
        // print
        //HashMap has .keySet() and .entrySet() for keys and values
        for (Map.Entry<Character, Integer> entry : results.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": count:" + entry.getValue());
            }
        }
    }

    // 1. Given a list of strings or chars
    // 2. create a HashSet of the list (unique values only)
    // 3. Iterate the HashSet and use Collections.frequency(list, s) to get count
    private static void method4() {

        List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");
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

        List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");

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

        List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");

        System.out.println("Method 6 use HashMap.merge():");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String s : list) {
            frequencyMap.merge(s, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
