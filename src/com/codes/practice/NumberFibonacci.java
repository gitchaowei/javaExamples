package com.codes.practice;

// fibonacci: a(n)= a(n-1) + a(n-2)
public class NumberFibonacci {
    //save numbers already calculated
    private static long[] fibonacciCatch;
    public static void main(String[] args) {
        int n=6; //6 fibonacci number is 8
//        int n = 92; // 92 is max number:  fibonacci number 7540113804746346429, long max 9223372036854775807
        fibonacciCatch = new long[n + 1];  // initialized 0;
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static long fibonacci(int n) {

        if (n < 2 ) {

            return n; //no need to calculate for 0 and 1
            // then
            //fibonacciCatch[0] = 0
            //fibonacciCatch[1] = 1
        }
        if (fibonacciCatch[n] != 0) {
            // for n > 1,
            // fibonacci number has been calculated. No need to calculate again.
            return fibonacciCatch[n];
        }
        // fibonacciCatch[n] is 0 here,
        // then calculate fibonacciCatch[n] = fibonacci(n - 1) + fibonacci(n - 2)
        fibonacciCatch[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return (fibonacciCatch[n]);
    }
}
