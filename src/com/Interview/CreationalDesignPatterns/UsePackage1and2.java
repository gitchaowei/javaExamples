package com.Interview.CreationalDesignPatterns;

import com.Interview.StructralDesignPatterns.TestClass1;
import com.Interview.BehavioralDesignPatterns.TestClassTwo;

public class UsePackage1and2 {
    public static void main(String[] args) {
        TestClass1 c1 = new TestClass1();
        TestClassTwo c2 = new TestClassTwo();
        c1.methodClassOne();
        c2.methodClassTwo();


        int a = 20, b = 10, c = 30, result;
        result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
        System.out.println("Max of three numbers = "
                + result);
    }

}
