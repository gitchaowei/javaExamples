package com.Interview.BehavioralDesignPatterns;

import java.util.Locale;

public class FormatNumbers {
    public static void main(String[] args) {

        String input = "1234567890.123456";
        double d = Double.parseDouble(input);

        // 2 decimal points
        System.out.println(String.format("%,.2f", d));     // 1,234,567,890.12

        // 4 decimal points
        System.out.println(String.format("%,.4f", d));     // 1,234,567,890.1235

        // 20 digits, if enough digits, puts 0
        System.out.println(String.format("%,020.2f", d));  // 00001,234,567,890.12

        // 10 decimal points, if not enough digit, puts 0
        System.out.println(String.format("%,.010f", d));   // 1,234,567,890.1234560000

        // in scientist format
        System.out.println(String.format("%e", d));        // 1.234568e+09

        // different locale - FRANCE
        System.out.println(String.format(
                Locale.FRANCE, "%,.2f", d));               // 1 234 567 890,12

        // different locale - GERMAN
        System.out.println(String.format(
                Locale.GERMAN, "%,.2f", d));               // 1.234.567.890,12

    }
}
