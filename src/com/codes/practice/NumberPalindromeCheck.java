package com.codes.practice;
import java.util.Scanner;

// check if original number and the reversed number are equal
public class NumberPalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scanner.nextInt();
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome number");
        } else {
            System.out.println(num + " is not a palindrome number");
        }
    }

    // check if original number and the reversed number are equal
    static boolean isPalindrome(int num) {
        int revNum = 0;
        int origNum = num;

        while (num > 0) {
            int rem = num % 10;
            revNum = rem + revNum * 10;
            num = num / 10;
        }
        if (origNum == revNum) {
            return true;
        } else {
            return false;
        }
    }
}
