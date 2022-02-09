package com.Interview;

import java.util.Scanner;

public class AdamNumber {

    //function that finds the reverse of the number
    static int reverseDigits(int num) {
//stores the reverse number
        int rev = 0;
//executes until the condition becomes false
        while (num > 0) {
//finds the last digit of the given number and add it to the variable rev
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
//returns the reverse number
        return rev;
    }

    //function that finds the square of the number
    static int square(int num) {
//returns the square
        return (num * num);
    }

    //function that checks if the number is Adam or not
    static boolean isAdamNumber(int num) {
// Square first number and square
// reverse digits of second number
        int a = square(num);
        int b = square(reverseDigits(num));
// If reverse of b equals a then given
// number is Adam number
//if the square of the number is equal to the square of reverse of the number
        if (a == reverseDigits(b))
//returns true if the number is an Adam number
            return true;
//returns false if the number is not an Adam number
        return false;
    }

    //driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
//reads an integer
        int num = sc.nextInt();
        if (isAdamNumber(num))
            System.out.println(num + " is an Adam number.");
        else
            System.out.println(num + " not an Adam number.");
    }

}
