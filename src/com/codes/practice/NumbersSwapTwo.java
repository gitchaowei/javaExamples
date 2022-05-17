package com.codes.practice;

// swap two numbers without a temporary variable
public class NumbersSwapTwo {
    public static void main(String[] args) {
        int x = 100, y = 200;

        System.out.println("Before swap: x= " + x + " y= " + y);
        y = x + y - (x = y);

        System.out.println("After swap: x= " + x + " y= " + y);
    }
}
