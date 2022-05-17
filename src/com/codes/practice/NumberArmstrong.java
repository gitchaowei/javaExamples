package com.codes.practice;

import java.util.Scanner;
// In case of an Armstrong number of 3 digits,
// the sum of cubes of each digits is equal to the number itself.
// For example: 153 = 1*1*1 + 5*5*5 + 3*3*3
// 153 is an Armstrong number.
//
public class NumberArmstrong {

    public static void main(String args[]) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        num = sc.nextInt();
        System.out.println("Armstrong Number: " + num + " is " + isArmstrong(num));

    }

    // check if the number is Armstrong or not
    static boolean isArmstrong(int n) {
        int temp=n, digits = 0, last = n, sum = 0;

        // calculate digits
        while (temp > 0) {
            temp = temp / 10;
            digits++;
        }

        temp = n;
        while (temp > 0) {
            last = temp % 10;
            sum += (Math.pow(last, digits));
            temp = temp/10;
        }
        if (n == sum)
            return true;
        else
            return false;
    }

}

