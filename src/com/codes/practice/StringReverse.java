package com.codes.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringReverse {

    public static void main(String[] args) {

        String str = "reverse string using StringBuffer and StringBuilder";
        stringBufferBuilderReverseMethod(str);

        String str1 = "reverse string using method 1";
        System.out.println("New reverse method 1 for : " + str1 + " is :" + reverseStringChars1(str1));

        String str2 = "reverse string using method 2";
        System.out.println("New reverse method 2 for : " + str2 + " is :" + reverseStringChars2(str2));

        String str3 = "reverse string words method 1";
        System.out.println("New reverse method 1 for : " + str3 + " is :" + reverseStringWords1(str3));

        String str4 = "reverse string words method 2";
        System.out.println("New reverse method 2 for : " + str4 + " is :" + reverseStringWords2(str4));

    }

    static String stringBufferBuilderReverseMethod(String str) {

        System.out.println("Original String is : " + str);

        // StringBuffer
        StringBuffer strb = new StringBuffer(str);
        String revStr = strb.reverse().toString();
        System.out.println("The reverted String using StringBuffer: " + revStr);

        //StringBuilder
        StringBuilder sb = new StringBuilder(str);
        revStr = sb.reverse().toString();
        System.out.println("The reverted String using StringBuilder: " + revStr);

        return revStr;

     }

     // recursive method
     public static String reverseStringChars1(String s)
     {
        //checks the string if empty
        if (s.isEmpty())
            return s;
        //recursively called function
        return reverseStringChars1(s.substring(1)) + s.charAt(0);
     }

    // Loop chars in the string
    // revert whole string chars
    static String reverseStringChars2(String origStr) {
        String nstr = "";
        for (int i = 0; i < origStr.length(); i++) {
            nstr = origStr.charAt(i) + nstr;
        }
        // System.out.println("reverted string is \'" + nstr + "\'.");
        return nstr;
    }

    static String reverseStringWords1(String origStr) {
        String delimiter = " ";
        String[] words = origStr.split(delimiter, 0) ;
        String nstr ="";

        // revert words
        for (int i= 0 ; i< words.length; i++) {

            nstr = words[i] + delimiter + nstr ;
        }
        return nstr;
    }

    // or use Corrections.reverse()
    // reverse of word sequence only not whole string of origStr
    static String reverseStringWords2(String origStr) {

        String delimiter = " ";
        String revStr = "";

        List<String> wordsList = Arrays.asList(origStr.split(delimiter, 0)) ;
        Collections.reverse(wordsList);

        for (String s: wordsList) {
            revStr = revStr + s + delimiter;
        }
//        System.out.print(wordsList.toString());

        return revStr;
    }
}
