//package com.codes.practice;
//
//public class NumberSmallestDivisible {
//    public static void main(String[] args) {
//        long lcm = 1;
//        for (long i=2; i<=20; i++) {
//            lcm = smallestDivisibleNumber(lcm,i);
//        }
//        System.out.println("LCM = " + lcm);
//    }
//
//    private static long smallestDivisibleNumber(long a, long b) {
//        long smallest=0;
//        long greater = a>b ? a:b;
//        long i =1;
//        long hcf =0, lcm=1;
//        while (i< greater) {
//            if (a%i==0 && b%i==0) {
//                hcf = i;
//            }
//            i++;
//        }
//        if (hcf !=0)
//            lcm = a*b/hcf;
//        return lcm;
//    }
//
//
//}
