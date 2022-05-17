package com.codes.practice;

public class NumberReverse {
    public static void main(String[] args) {
        int origNum = 17291, revNum = 0;
        while (origNum > 0) {
            int rem = origNum % 10;
            revNum = rem + revNum * 10;
            origNum = origNum / 10;
        }
        System.out.println(revNum);
    }
 }
