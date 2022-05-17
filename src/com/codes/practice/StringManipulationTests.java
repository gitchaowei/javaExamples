package com.codes.practice;

import java.util.ArrayList;

public class StringManipulationTests {

    public static void main(String[] args) {
        String str = "Revert treveR";
        String str1 = new String(str);

        System.out.println(str==str1);          // false by comparing memory locations
        System.out.println(str.equals(str1));   // true by comparing only values

        String s1 = "Sharma is a good player";                      // s1 is in String Constant Pool (SCP)
        String s2 = new String("Sharma is a good player"); // s2 is in heap
        //s2 = s2.intern(); // Make s2 in SCP
        String s3 = s2.concat(" !!!");  // s3 is in SCP now
        String s4 = "Sharma is a good player !!!";

        System.out.println(s3 ==s4);        // true: both are in SCP
        System.out.println(s1 ==s2);        //false: not same object. true when use s2.intern()
        System.out.println(s1.equals(s2)); //true: same contain

        // example 1: split()
        str1 = str1 + " " + "Edureka";
        System.out.println("The final String is - " + str1);
        // to string array
        String [] strArr = str1.split(" ");
        System.out.println("The final String array - " + strArr[0] + "," + strArr[1] + "," + strArr[2] + " , Length: " + strArr.length);

        // example 2: split()
        String str0 = "  We're, Ridiculously Committed!   Welcome to Eduerka.Hello[world] Chao+++Wei";
        str0= str0.trim(); // try with or without trim leading spaces
        String[] arrOfStr = str0.split("[, .!+]+"); // without using of limit
        //String[] arrOfStr = str0.split("[, .!+]+", 0);  // with using of limit
        System.out.println("Number of substrings: "+ arrOfStr.length);

        for(int i=0; i< arrOfStr.length; i++)
        {
            System.out.println("str["+i+"] : "+ arrOfStr[i]);
        }
        // to arrayList
        ArrayList<String> strList = new ArrayList<>();
        strList.add(strArr[0]);
        strList.add(strArr[1]);
        strList.add(strArr[2]);
        System.out.println("The final String array list - " + strList + ", Size: " + strList.size()) ;
    }
}
