package com.codes.practice;

// Factorial: n[x] = n[x-1] * n[x-2] * ... (
public class NumberFactorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial value " + factorial(n) + " of n " + n);
    }

    static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
