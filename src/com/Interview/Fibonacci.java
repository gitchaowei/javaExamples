package com.Interview;

public class Fibonacci {
    private static long[] fibonacciCatch;  //save numbers already calculated

    public static void main(String[] args) {
//        int n=6; //6 fibonacci number is 8
        int n = 92; // 92 is max number:  fibonacci number 7540113804746346429, long max 9223372036854775807
        fibonacciCatch = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }

    private static long fibonacci(int n) {

        if (n <= 1) {
            return n; //no need to calculate for 0 and 1
        }
        if (fibonacciCatch[n] != 0) {
            return fibonacciCatch[n];
        }
        long nthFibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciCatch[n] = nthFibonacciNumber;

        return (nthFibonacciNumber);
    }


}
