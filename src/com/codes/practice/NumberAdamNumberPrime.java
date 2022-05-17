package com.codes.practice;

import java.util.Scanner;

// Adam Number is a number whose square is reverse of the square of its reverse.
public class NumberAdamNumberPrime {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the lower limit: ");
        int m = in.nextInt();
        System.out.print("Enter the upper limit: ");
        int n = in.nextInt();
        int count = 0;
        if (m >= n) {
            System.out.println("Enter valid input! the value of m should be greater than or equal to n.");
            return;
        }
        System.out.println("The prime Adam numbers are:");
        for (int i = m; i <= n; i++) {
            boolean adam = isAdam(i);
            if (adam) {
                boolean prime = isPrime(i);
                if (prime) {
                    System.out.print(i + " ");
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.print("NIL");
        }
        System.out.println();
        System.out.println("Frequency of Adam number is: " + count);
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }

    //function check if the number is Adam or not
    public static boolean isAdam(int num) {
        int revNum = reverse(num);
        int sqRevNum = revNum * revNum;

        int sqNum = num * num;
        int rev = reverse(sqNum);

        return rev == sqRevNum;
    }

    //checks if the number Adam number is prime or not
    public static boolean isPrime(int num) {
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        return c == 2;
    }
}
