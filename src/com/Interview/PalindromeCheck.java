package com.Interview;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num = scanner.nextInt();
        int revNum = 0;
        int origNum = num;

        while (num > 0) {
            int rem = num % 10;
            revNum = rem + revNum * 10;
            num = num / 10;
        }

        if (origNum == revNum) {
            System.out.println(origNum + "is a palindrome number");
        } else {
            System.out.println(origNum + "is not a palindrome number");

        }

        // swap two numbers
        int x = 100, y = 200;

        System.out.println("Before swap: x= " + x + " y= " + y);
        y = x + y - (x = y);

        System.out.println("After swap: x= " + x + " y= " + y);

        // find numbers of digits in a given number
        num = origNum;
        int count = 0;

        while (num != 0) {
            num = num / 10;
            count++;
        }
        System.out.println("Number of digits is " + count);

        //Find number of Even and Odd Digits in a Given Number
        // sum of digits
        num = origNum;
        int countEven = 0, countOdd = 0, sum = 0;

        while (num > 0) {
            int remainder = num % 10;
            sum = sum + remainder;
            if (remainder % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
            num = num / 10;

        }
        System.out.println("Even Number of digits is " + countEven + " and odd Number of digits is " + countOdd);
        System.out.println("Sum of digits is " + sum);

        //Print Even and Odd Numbers from an Array
        int[] a = {4, 9, 16, 25, 36};

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.print(a[i] + " ");
            } else {
                sb.append(a[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Odd numbers in the Array: " + sb);
//Find Maximum and Minimum values from an Array


    }
}
