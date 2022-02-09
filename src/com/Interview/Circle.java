package com.Interview;

import java.io.BufferedReader;
import java.io.FileReader;

public class Circle {
    public static void main(String[] args) {
        System.out.println(formatRGB(200, 210, 255));
//        sumFile("C:\\Examples\\src\\com\\Interview\\data.txt");
//        double d;
//        d = area(8.9);
//        System.out.println(String.format("%.5f", d));
//        int a = rectArea(34, 23);
//        int numofTiles = a / 12 / 12 + 1;
//        System.out.println(numofTiles);
//
//        Circle p = new Circle();
//        p.start();
//        int x = 2, y = 3;
//        boolean b = (x == y);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.print(fib(i) + " ");
//        }
    }

    static double area(double r) {
        return Math.PI * r * r;
    }

    static int rectArea(int m, int n) {
        return m * n;
    }

    static long[] fix(long[] a3) {
        a3[1] = 7;
        return a3;
    }

    static long fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

    static void sumFile(String name) {
        int total = 0;
        BufferedReader in = null;
        try {
            FileReader fr = new FileReader(name);
            in = new BufferedReader(fr);
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                total += Integer.parseInt(s);
            }
            System.out.println(total);
            in.close();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    void start() {
        long[] a1 = {3, 4, 5};
        long[] a3 = a1;
        long[] a2 = fix(a1);
        System.out.println(a1[0] + a1[1] + a1[2]);
        System.out.println(a2[0] + a2[1] + a2[2]);
    }

    static String formatRGB(int r, int g, int b) {
//        return (toHex(r)+toHex(g)+toHex(b)).toUpperCase();
        return (toHex(r) + toHex(g) + toHex(b));
    }

    static String toHex(int a) {
        String as = Integer.toHexString(a);
        if (as.length() == 1) as = "0" + as;
        return as;
    }
}
