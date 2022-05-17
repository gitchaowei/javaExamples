package com.codes.practice;

public class NumberPrime {

    public static void main(String[] args) {

        int num = 29;

        // mehod 1
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println(num + " is not a prime number.");
        else
            System.out.println(num + " is a prime number.");

        // mehod 2
        int count =0;
        for (int i = 2; i < num; ++i) {
            // Exclude 1 and num
            // condition for nonprime number
            //
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 0)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}
