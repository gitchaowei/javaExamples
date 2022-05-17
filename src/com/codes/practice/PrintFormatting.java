package com.codes.practice;

import java.io.Console;
import java.util.Locale;
import java.util.Date;

public class PrintFormatting {
    public static void main(String[] args) {
        numberFormatting1();
        numberFormatting2();
    }

    private static void numberFormatting1() {

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

    private static void numberFormatting2() {

        // Integer
        int a = 12;
        int b = 45;
        int c = a + b;
        System.out.printf("Sum of %d and %d is %d.%n", a,b, c);
        //Sum of 12 and 45 is 57.
        System.out.printf(Locale.US, "%,d %n", 12300);
        System.out.printf(Locale.ITALY, "%,d %n", 10000);


        // print to console:
//        Console obj = System.console();
//        if (obj != null) {
//            String fmt = "%1$4s %2$10s %3$10s%n";
//            // format
//            obj.printf(fmt, "cse", "program", "language");
//            obj.printf(fmt, "-----", "-----", "-----");
//            obj.printf(fmt, "PHP", "Java", "Python");
//            obj.printf(fmt, "CSS", "Html", "JavaScript");
//        }
        String fmt = "%1$4s %2$10s %3$10s%n";
        // format
        System.out.printf(fmt, "cse", "program", "language");
        System.out.printf(fmt, "-----", "-----", "-----");
        System.out.printf(fmt, "PHP", "Java", "Python");
        System.out.printf(fmt, "CSS", "Html", "JavaScript");

        System.out.printf("%s%n", "hello world!");
        System.out.printf("'%S' %n", "hello world!");
        System.out.printf("'%10s' %n", "Hello");
        System.out.printf ("'%-10s' %n", "Hello");

        // boolean
        boolean adult = true;
        boolean member = false;
        System.out.printf("%b%n", adult);
        System.out.printf("%b%n", null);
        System.out.printf("%b%n", "random text");
        System.out.printf("%b%n", member);

        // float and double
        System.out.printf("%f%n", 3.1423);
        System.out.printf("'%3.2f'%n", 3.1423);
        System.out.printf("'%3.2e'%n", 3.1423);

        // Date
        Date date = new Date();
        System.out.printf("%tT%n", date);
        System.out.printf("hours: %tH minutes: %tM seconds: %tS%n", date, date, date);
        System.out.printf("%1$tA, %1$tB %1$tY %n", date);
        System.out.printf("%1$td-%1$tm-%1$ty %n", date);
    }
}
