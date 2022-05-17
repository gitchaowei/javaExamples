package com.codes.practice;

public class NumberOfDigitials {
    public static void main(String[] args) {
        // find numbers of digits in a given number
        int num = 5478;
        int count = 0;

        while (num != 0) {
            num = num / 10;
            count++;
        }
        System.out.println("Number of digits is " + count);
    }
}
