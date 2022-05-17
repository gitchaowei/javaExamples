package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Array2List {

    public static void main(String[] args) {
        //LoopAddToArrayList();
//        ArraysAsList();
        //ArraysAsListException();
        //CollectionsAddAll();

        int A[] = {0, -1, 2, -3, 1};
        int B[] = {5, -1, 2, -3, 1, 7,12,65};
        int[] C;

        System.out.println("Original int Array: " + Arrays.toString(A));

        List <Integer> list = new ArrayList<>();
        list = intArray2List(A);
        System.out.println("int Array to ArrayList: " + list);

        C = list2intArray(list);
        System.out.println("List to int Array: " + Arrays.toString(C));
    }

    public static void LoopAddToArrayList() {

        /*ArrayList declaration*/
        List<String> arraylist= new ArrayList<String>();

        /*Initialized Array*/
        String array[] = {"Text1","Text2","Text3","Text4"};

        /*array.length returns the current number of
         * elements present in array*/
        for(int i =0;i<array.length;i++)
        {
            /* We are adding each array's element to the ArrayList*/
            arraylist.add(array[i]);
        }

        /*ArrayList content*/
        for(String str: arraylist)
        {
            System.out.println(str);
        }
    }

    public static void CollectionsAddAll() {
        /* Array Declaration and initialization*/
        String array[]={"Hi", "Hello", "Howdy", "Bye"};

        /*ArrayList declaration*/
        ArrayList<String> arraylist= new ArrayList<String>();
        /*Conversion*/
        // arraylist and array much be same type of object.
        // They are all String here. However, int and Integer are not same type
        Collections.addAll(arraylist, array);

        /*Adding new elements to the converted List*/
        arraylist.add("String1");
        arraylist.add("String2");

        /*Display array list*/
        for (String str: arraylist)
        {
            System.out.println(str);
        }
    }

    public static List<Integer> intArray2List(int [] intArray) {

        List<Integer> list = new ArrayList<>(intArray.length);
       // method 1
        list = Arrays.stream(intArray)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());

        // method 2: using `IntStream.of()`
        list = IntStream.of(intArray)    // returns IntStream
                .boxed()
                .collect(Collectors.toList());

        // method 3:
        // Converting primitive integer array to an Integer array
        Integer[] boxedArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        // add all elements of the Integer array to a empty list of Integer
        list.clear(); // initialize list
        Collections.addAll(list, boxedArray);

        // method 4:
        list.clear(); // initialize list
        for (int i: intArray) {
            list.add(Integer.valueOf(i));
        }

        return list;
    }

    public static int[] list2intArray(List <Integer> list) {

        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

//        System.out.println(Arrays.toString(primitive));

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

        return primitive;
    }


    //List <T1> list Arrays.asList(T2): T1 and T2 much be same type Object
    // int and Integer are not same type
    public static void ArraysAsList() {

        /* Array Declaration and initialization*/
        String [] citynamesArray ={"Agra", "Mysore", "Chandigarh", "Bhopal"};

        //Array to ArrayList conversion with new ArrayList created
        List<String> citynameList= new ArrayList<String>(Arrays.asList(citynamesArray));

//        List<String> citynameList= Arrays.asList(citynamesArray);  // without new ArrayList, will throw exception
//        citynameList.add("add to list"); // throws exception since wrapper to String array is immutable

        /*Adding new elements to the converted List*/
        citynameList.add("New City2");
        citynameList.add("New City3");

        // convert List back to Array: 2 ways
        Object [] cityArray = citynameList.toArray();
        String [] cityStrArray = citynameList.toArray(new String[citynameList.size()]);
        // Difference between toArray() and toArray( T[]): toArray() is instantiating an Objects and not Strings
        // 1. no runtime error:
        //Object [] tSObjectArray = new String[2];  //tSObjectArray is pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;
        // 2. runtime error:
        //Object [] tSObjectArray = new Object[2];  // tSObjectArray is not pointing to String array
        //String [] tStringArray = (String[]) tSObjectArray;

        /*Final ArrayList content display using for*/
        // All three have same printout
        for (String str: citynameList)
        {
            System.out.println(str);
        }
        for (Object obj: cityArray)
        {
            System.out.println(obj.toString());
        }
        for (String str: cityStrArray)
        {
            System.out.println(str);
        }
    }

    public static void ArraysAsListException() {

        /* Array Declaration and initialization*/
        String [] strArray ={"Agra", "Mysore", "Chandigarh", "Bhopal"};

        // This List is just a wrapper that makes the array available
        // as a list (Array.asList()). No new list data is copied or created.
        List <String> strList = Arrays.asList(strArray);

        //change an element
        strList.set(0,"Agra new");

        // result in both strArray and strList contain the same elements
        for (String str: strList)
        {
            System.out.println(str);
        }
        for (int i=0; i< strArray.length; i++ ) {
            System.out.println(strArray[i]);
        }

//
// adding/removing elements to/from the strList will throw java.lang.UnsupportedOperationException,
// since strArray[] can not be added or deleted, and so its wrapper (strList) can not be added or deleted either.
//
        //strList.add("new string element"); // throw java.lang.UnsupportedOperationException

        // Array to new ArrayList has no such exception issue since
        // Array to ArrayList conversion with a new ArrayList created
        //
        List<String> strListnew = new ArrayList<String>(Arrays.asList(strArray));
        strListnew.add("new string element"); // no problem
        for (String str: strListnew)
        {
            System.out.println(str);
        }
    }
}
