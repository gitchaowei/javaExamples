package com.codes.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private static final int MONTHS_IN_A_YEAR = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter the annual interest rate:");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Enter the term in years:");
        int termInYears = scanner.nextInt();
        scanner.close();

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;

        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;

        double monthlyPayment = principal *
                monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    }
}
