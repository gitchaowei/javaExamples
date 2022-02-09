package com.Interview;

import java.util.Scanner;

public class AdamNumberPrime {
    //function that finds the reverse of the given number
    public static int reverse(int num) {
        int rev = 0;
//executes until the condition becomes false
        while (num != 0) {
//finds the last digit of the given number
            int d = num % 10;
//adds the last digit in the variable rev
            rev = rev * 10 + d;
//removes the last digit
            num = num / 10;
        }
//returns the reverse of the given number
        return rev;
    }

    //function check if the number is Adam or not
    public static boolean isAdam(int num) {
//finds the square of the num
        int sqNum = num * num;
//calling the user-defined function that finds the reverse of the number
        int revNum = reverse(num);
//find the square of the reverse number
        int sqRevNum = revNum * revNum;
//reverse the square of the number
        int rev = reverse(sqNum);
//compares the reverse of the number with the reverse of square of the number
        return rev == sqRevNum;
    }

    //function checks if the number Adam number is prime or not
    public static boolean isPrime(int num) {
        int c = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        return c == 2;
    }

    //driver code
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
//prints all the Adam number between given range
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

}
