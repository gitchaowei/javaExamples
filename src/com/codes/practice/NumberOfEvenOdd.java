package com.codes.practice;

public class NumberOfEvenOdd {
    public static void main(String[] args) {
        // 1. Find number of Even and Odd Digits in a Given Number
        // 2. sum of digits
        int countEven = 0, countOdd = 0, sum = 0;
        int num = 234565672;
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

        // 3. Print Even and Odd Numbers from an Array
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
    }
}
