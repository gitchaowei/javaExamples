package com.codes.practice;

import java.util.Arrays;

public class ArrayCopyRange {
    public static void main(String[] args) {
        char[] charArray = "This is a java tutorial, array of characters".toCharArray();
        char[] charTarget = Arrays.copyOfRange(charArray, 25,charArray.length);
        for(char c: charTarget){
            System.out.print(c);
        }
    }
}
