package com.Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysToArrayList {

    public static void main(String[] args) {
        LoopAddToArrayList();
        ArraysAsList();
        CollectionsToArrays();
    }

    public static void LoopAddToArrayList() {

        /*ArrayList declaration*/
        ArrayList<String> arraylist= new ArrayList<String>();

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

    public static void CollectionsToArrays() {
        /* Array Declaration and initialization*/
        String array[]={"Hi", "Hello", "Howdy", "Bye"};

        /*ArrayList declaration*/
        ArrayList<String> arraylist= new ArrayList<String>();

        /*Conversion*/
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
    public static void ArraysAsList() {

        /* Array Declaration and initialization*/
        String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal"};

        /*Array to ArrayList conversion*/
        ArrayList<String> citylist= new ArrayList<String>(Arrays.asList(citynames));

        /*Adding new elements to the converted List*/
        citylist.add("New City2");
        citylist.add("New City3");

        // convert back to Array: 2 ways
        Object [] cityArray = citylist.toArray();
        String [] cityStrArray = citylist.toArray(new String[citylist.size()]);

        /*Final ArrayList content display using for*/
        for (String str: citylist)
        {
            System.out.println(str);
        }
    }

}
