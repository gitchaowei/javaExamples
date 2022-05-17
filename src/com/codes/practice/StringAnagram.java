package com.codes.practice;

import java.util.Arrays;
//
// To check whether two given strings are anagram of each other or not.
// An anagram of a string is another string that contains the same characters, only the order of characters can be different.
public class StringAnagram {
    public static void main(String[] args) {
        isAnagram("K e e p", "P e e ks");
        isAnagram("Mother In Law", "Hitler Woman");
    }
    static void isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }
}

