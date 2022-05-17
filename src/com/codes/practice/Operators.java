package com.codes.practice;

public class Operators {
    public static void main(String[] args) {
        int x = 1, y = 3;
        System.out.println("x = " + x + "y = " + y);
        System.out.println("++x = " + (++x) + " y++ = " + (y++));
        System.out.println("~x = " + (~x) + " ~y = " + (~y++));
        operator1();
    }
    private static void operator1() {
        // Initial values
        int a = 5;
        int b = 7;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise not
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a);

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);
        // output:
        // a&b = 5
        // a|b = 7
        // a^b = 2
        // ~a = -6
        // a= 5
        //
        int number = 2;

        // 2 bit left shift operation
        //output: 8
        int Ans = number << 2;
        System.out.println(Ans);

        // 2 bit signed right shift
        //output: 2
        number = 8;
        Ans = number >> 2;

        System.out.println(Ans);

        byte num1 = 8;
        byte num2 = -8;

        // the Unsigned right shift operator
        //output:
        // 2
        //1073741822
        System.out.println(num1 >>> 2);
        System.out.println(num2 >>> 2);
        //
    }
}



