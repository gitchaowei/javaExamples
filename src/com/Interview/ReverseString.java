package com.Interview;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class ReverseString {

    public static void main(String[] args) {

        String str = "Revert treveR";

        String str1 = new String(str);

        String s1 = "Sharma is a good player";
        String s2 = new String("Sharma is a good player");
        //s2 = s2.intern();
        System.out.println(s1 ==s2);
//
//        System.out.println(str==str1);
//
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
        System.out.println("Number of substrings: "+arrOfStr.length);

        for(int i=0; i< arrOfStr.length; i++)
        {
            System.out.println("str["+i+"] : "+arrOfStr[i]);
        }
        // to arrayList
        ArrayList<String> strList = new ArrayList<>();
        strList.add(strArr[0]);
        strList.add(strArr[1]);
        strList.add(strArr[2]);
        System.out.println("The final String array list - " + strList + ", Size: " + strList.size()) ;

        StringBuffer str2 = new StringBuffer();
            str2.append("Edureka");
        System.out.println("The final String is - " + str2);
          String revStr = new StringBuffer(str0).reverse().toString();
        System.out.println("The final reverted String is - " + revStr);
        StringBuilder str3 = new StringBuilder();
            str3.append("Edureka");
        System.out.println("The final String is -" + str3);

            ReverseString rs = new ReverseString();  // create a class instance
        if (rs.bFindPalindromeString(str) == true) {
            System.out.println("String :" + str + " is a Palindrome string");
        } else {
            System.out.println("String :" + str + " is not Palindrome string");
        }

    }

    public String revertString(String origStr) {
        String delimiter = " ";
//        String[] words = origStr.split(delimiter, 0) ;
//        String nstr ="";
//
//        // revert words
//        for (int i= 0 ; i< words.length; i++) {
//
//            nstr = words[i] + delimiter+ nstr ;
//        }

        // or use Corrections
//        List<String> wordsList = Arrays.asList(origStr.split(delimiter, 0)) ;
//        Collections.reverse(wordsList);
//        for (String s: wordsList) {
//            System.out.print(s + " ");
//        }
//        System.out.print(wordsList.toString());

//        System.out.println("original string is \'" + origStr + "\'.");
//        System.out.println("reverted words are \'" + nstr + "\'.");

        // revert whole string
//        String nstr="";
//        for (int i=origStr.length()-1; i>=0 ; i--) {
//
//            nstr += origStr.charAt(i) ;
//        }
//        System.out.println("reverted string is \'" + nstr + "\'.");
        String nstr = "";
        for (int i = 0; i < origStr.length(); i++) {

            nstr = origStr.charAt(i) + nstr;
        }
        System.out.println("reverted string is \'" + nstr + "\'.");
        return nstr;

    }

    public boolean bFindPalindromeString(String origStr) {
        String revertStr;
        boolean isPalindromeStr = true;

        // method 1
        int i = 0, j = origStr.length() - 1;

        while (i < j) {
            if (origStr.charAt(i) != origStr.charAt(j)) {
                isPalindromeStr = false;
                break;
            }
            i++;
            j--;
        }
//        // method 2
//        revertStr = revertString(origStr);
//        if (!revertStr.equals(origStr)) {
//            isPalindromeStr = false;
//        }

        return isPalindromeStr;

    }
}
