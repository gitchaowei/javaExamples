package com.codes.practice;

import java.util.*;

public class Array2Set4String {
    public static void main(String[] args) {
        ArrayToSet();
        SetToArray();
    }
    public static void ArrayToSet() {
        // instantiating an array of Strings
        String[] arrayString = new String[]{"grace", "michael", "anne"};

        // this list <String> is a wrapper of arrayString by using Arrays.asList()
        // the list is String type
        List<String> list = Arrays.asList(arrayString);
        //
        // this list <String> is a wrapper of arrayString by using Arrays.asList()
        // the list is Object type
//        List list = Arrays.asList(arrayString);

        // this new list <String> created, not a wrapper
//        List<String> list = new ArrayList<String> (Arrays.asList(arrayString));
        for (String s : list) {
//        for (Object s : list) {
            System.out.println(s);
        }

        // this set <String> is created by copying arrayString
        // convert the ArrayList to HashSet: may loose some data because HashSet values are unique
        Set<String> set = new HashSet<>(list);

        // this set <Object> is created by copying ArrayList
//        Set set = new HashSet<>(list);
        for (String s : set) {
//        for (Object s : set) {
            System.out.println(s);
        }
        // getting first the size of the set
        System.out.println("Initial size of set:" + set.size());
        // add a duplicate string to our set
        set.add("grace");
        System.out.println("Size of the set after adding:" + set.size());
    }

    public static void SetToArray() {

        Set<String> strSet = new HashSet<String>();  // a String Set
        //Set objSet = new HashSet();                  // Object Set, see difference below for toArray() called
        //
        // adding elements to our set
        strSet.add("Switzerland");
        strSet.add("Land of Java Tutorial");
        strSet.add("Array Example");

        // Converting set to Array using Set.toArray()
        String [] arrayString = strSet.toArray(new String[strSet.size()]);
//        String [] arrayString = (String []) objSet.toArray(new String[objSet.size()]);  //need to cast
        // or
//        Object [] arrayObj = strSet.toArray();
//        for(Object s: arrayObj) {
//            System.out.println(s);
//        }

        for(String s: arrayString){
           // printing the contents of our array
           System.out.println(s);
        }
    }
}
