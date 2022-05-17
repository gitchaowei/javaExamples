package com.codes.practice;

import java.util.*;

public class ArrayPrint {
    public static void main(String[] args) {
        // test each
//        StreamForEach();
//        IteratorInterface();
        intArrayPrint();
//        ArraysasListObjectPrint();
//        DeepToString();
//        ForEachLoopArray();
//        ForLoopArray();
    }

    public static void StreamForEach() {
        //declaration and initialization of an array of String type
        String[] arr = {"Java", "C", "C++", "Python", "Perl"};
        //iterating by passing the method reference
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void IteratorInterface() {
        //declaration and initialization of an array of Double type
        Double[] array = {1.5, 2.6, 3.7, 4.8, 5.9};
        //returns an iterator
        Iterator<Double> it = Arrays.asList(array).iterator();
        for ( Double d: array) {
            System.out.println(d);
        }
        System.out.println("iterator .next() print: ");
        while (it.hasNext()) //returns a boolean value
        {
            System.out.println(it.next());
        }
    }

    public static void ArraysasListObjectPrint() {
        //declaration and initialization of two dimensional array
        String[] stringArray = {"Hello", "Java", "Programmers"};
        List<String> strList = Arrays.asList(stringArray);
        System.out.println("Print List array object:");
        System.out.println(strList);
    }

    public static void DeepToString() {
        //declaration and initialization of two dimensional array of float type
        float[][] array = {{1.2f, 2.5f}, {3.9f, 4.0f}, {5.3f, 6.2f}};
        System.out.println("Arrays.deepToString(array):");
        System.out.println(Arrays.deepToString(array));
    }

    public static void intArrayPrint() {
        //declaring and initializing array
        int array[] = {34, -10, 56, -9, -33};
        //returns string representation of the specified array
        System.out.println("Arrays.toString(array):");
        System.out.println(Arrays.toString(array));


        List<Integer> intList = new ArrayList(Arrays.asList(array));
        System.out.println("Print reference pointer of List wrapper of int array (wrong way): " +intList);
        System.out.println("Print reference pointer of int array only (wrong way): " +intList);

        Integer[] IntArr={34, -10, 56, -9, -33};
        List<Integer> IntList = Arrays.asList(IntArr);
        System.out.println("Print Integer List object (right):" +IntList);

    }

    public static void ForEachLoopArray() {
        // declaration and instantiation of an array
        String[] city = new String[4];
        //initializing elements
        city[0] = "Delhi";
        city[1] = "Jaipur";
        city[2] = "Gujarat";
        city[3] = "Mumbai";
        //traversing over array using for-each loop
        System.out.println("for-each loop:");
        for (String str : city) {
            System.out.println(str);
        }
    }

    public static void ForLoopArray() {
        //declaration and instantiation of an array
        int [] arr =new int[4];
        //initializing elements
        arr[0]=10;
        arr[1]=20;
        arr[2]=70;
        arr[3]=40;
        //traversing over array using for loop
        System.out.println("for loop of array: ");
        for(int i=0;i<arr.length;i++)    //length is the property of the array
            System.out.println(arr[i]);
    }
}