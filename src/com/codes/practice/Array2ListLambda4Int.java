package com.codes.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Array2ListLambda4Int {
    public static void main(String[] args) {
        // convert int array to Integer ArrayList
        int[] arr = {1, 2, 9, 4, 5, 0};
        Integer[] IntegerArr = {1, 2, 9, 4, 5, 0};
        ArrayList<Integer> list = new ArrayList<>(arr.length); // initialized with a capacity but can be extended later

        for (int i : arr) {
            list.add(Integer.valueOf(i));
        }
        list.add(50);  // add to the end
        list.add(3,30); // insert at index 3
        list.remove(3);         // remove element at index 3
        list.add(3,30); // insert at index 3
        list.remove(Integer.valueOf(30));         // remove first element (Object, not index) of 30

        System.out.println(list);

        // convert Integer ArrayList to int array
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);

        for (int x : ret) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Use ArrayList.toArray() to convert back to Array: 2 ways
        Object [] arrObj = list.toArray();
        Integer [] arrInteger = list.toArray(new Integer[list.size()]);

        // difference between toArray() and toArray( T[]): toArray() is instantiating a Objects and not Strings
        // 1. no runtime error:
        //Object [] tSObjectArray = new String[2];  //tSObjectArray is pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;
        // 2. runtime error:
        //Object [] tSObjectArray = new Object[2];  // tSObjectArray is not pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;

        /*Final ArrayList content display using for*/
        // All three have same printout
        for (Integer i: arrInteger)
        {
            System.out.println(i);
        }
        for (Object obj: arrObj)
        {
            System.out.println(obj);
        }
        for (Integer i: list)
        {
            System.out.println(i);
        }

        //
        //List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);  //OK
        //List<Integer> list2 = Arrays.asList(arr); // Not OK with primitive type
        List<Integer> list2 = Arrays.asList(IntegerArr); // OK

        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(primitive));

        //1. Filter out the null values before mapping:
        //
        //int[] primitive = list.stream()
        //                    .filter(Objects::nonNull)
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        //2. Map the null values to a default value:
        //
        //int[] primitive = list.stream()
        //                    .map(i -> (i == null ? 0 : i))
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        //3. Handle null inside the lambda expression itself:
        //int[] primitive = list.stream()
        //                    .mapToInt(i -> (i == null ? 0 : i))
        //                    .toArray();
    }
}
